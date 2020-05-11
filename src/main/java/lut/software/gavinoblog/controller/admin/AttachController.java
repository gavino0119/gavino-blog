package lut.software.gavinoblog.controller.admin;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lut.software.gavinoblog.common.api.QiNiuCloudService;
import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.common.constant.LogActions;
import lut.software.gavinoblog.common.constant.Types;
import lut.software.gavinoblog.common.constant.WebConst;
import lut.software.gavinoblog.common.exception.BusinessException;
import lut.software.gavinoblog.common.utils.APIResponse;
import lut.software.gavinoblog.common.utils.Commons;
import lut.software.gavinoblog.common.utils.TaleUtils;
import lut.software.gavinoblog.controller.BaseController;
import lut.software.gavinoblog.dto.AttAchDto;
import lut.software.gavinoblog.pojo.AttAch;
import lut.software.gavinoblog.pojo.User;
import lut.software.gavinoblog.service.attach.AttAchService;
import lut.software.gavinoblog.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/4/3 17:26
 */
@Api("文件管理")
@Controller
@RequestMapping("admin/attach")
public class AttachController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachController.class);

    public static final String CLASSPATH = TaleUtils.getUploadFilePath();

    @Autowired
    private AttAchService attAchService;

    @Autowired
    private LogService logService;



    @ApiOperation("文件管理首页")
    @GetMapping(value = "")
    public String index(
            HttpServletRequest request,
            @ApiParam(name = "page", value = "页数", required = false)
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int page,
            @ApiParam(name = "limit", value = "条数", required = false)
            @RequestParam(name = "limit", required = false, defaultValue = "12")
                    int limit
    ) {
        PageInfo<AttAchDto> atts = attAchService.getAtts(page, limit);
        request.setAttribute("attachs", atts);
        request.setAttribute(Types.ATTACH_URL.getType(),Commons.site_option(Types.ATTACH_URL.getType(), Commons.site_url()));
        request.setAttribute("max_file_size", WebConst.MAX_FILE_SIZE / 1024);
        return "admin/attach";
    }

    @ApiOperation("markdown文件上传")
    @PostMapping(value = "/uploadfile")
    public void fileUploadToTencentCloud(
            HttpServletRequest request,
            HttpServletResponse response,
            @ApiParam(name = "editormd-image-file", value = "文件数组", required = true)
            @RequestParam(name = "editormd-image-file", required = true)
                    MultipartFile file
    ) {

    }


    @ApiOperation("多文件上传")
    @PostMapping(value = "upload")
    @ResponseBody
    public APIResponse filesUploadToCloud(
            HttpServletRequest request,
            HttpServletResponse response,
            @ApiParam(name = "file", value = "文件数组", required = true)
            @RequestParam(name = "file", required = true)
                    MultipartFile[] files
    ) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type","text/html");

            for (MultipartFile file :files) {

                String fileName = TaleUtils.getFileKey(file.getOriginalFilename().replaceFirst("/", ""));

                QiNiuCloudService.upload(file, fileName);
                AttAch attAchDomain = new AttAch();
                HttpSession session = request.getSession();
                User sessionUser = (User) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
                attAchDomain.setAuthorId(sessionUser.getUid());
                attAchDomain.setFtype(TaleUtils.isImage(file.getInputStream()) ? Types.IMAGE.getType() : Types.FILE.getType());
                attAchDomain.setFname(fileName);
                attAchDomain.setFkey(QiNiuCloudService.QINIU_UPLOAD_SITE + fileName);
                attAchService.addAttAch(attAchDomain);
            }
            return APIResponse.success();

        } catch (IOException e) {
            e.printStackTrace();
            throw BusinessException.withErrorCode(ErrorConstant.Att.ADD_NEW_ATT_FAIL)
                    .withErrorMessageArguments(e.getMessage());
        }

    }

    @ApiOperation("删除文件")
    @PostMapping(value = "/delete")
    @ResponseBody
    public APIResponse deleteFileInfo(
            HttpServletRequest request,
            @ApiParam(name = "id", value = "文件主键", required = true)
            @RequestParam(name = "id", required = true)
                    Integer id
    ) {
        try {
            AttAchDto attach = attAchService.getAttAchById(id);
            if (null == attach)
                throw BusinessException.withErrorCode(ErrorConstant.Att.DELETE_ATT_FAIL + ": 文件不存在");
            attAchService.deleteAttAch(id);
            // 写入日志
            logService.addLog(LogActions.DEL_ATTACH.getAction(),this.user(request).getUsername()+"用户",request.getRemoteAddr(),this.getUid(request));
            return APIResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw BusinessException.withErrorCode(e.getMessage());
        }
    }

}