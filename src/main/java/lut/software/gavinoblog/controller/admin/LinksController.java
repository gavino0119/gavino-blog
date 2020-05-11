package lut.software.gavinoblog.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lut.software.gavinoblog.common.constant.ErrorConstant;
import lut.software.gavinoblog.common.constant.Types;
import lut.software.gavinoblog.common.exception.BusinessException;
import lut.software.gavinoblog.common.utils.APIResponse;
import lut.software.gavinoblog.controller.BaseController;
import lut.software.gavinoblog.dto.cond.MetaCond;
import lut.software.gavinoblog.pojo.Meta;
import lut.software.gavinoblog.service.meta.MetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/4/9 12:37
 */
@Api("友情链接管理")
@Controller
@RequestMapping("/admin/links")
public class LinksController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinksController.class);

    @Autowired
    private MetaService metaService;


    @ApiOperation("友链页面")
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        MetaCond metaCond = new MetaCond();
        metaCond.setType(Types.LINK.getType());
        List<Meta> metas = metaService.getMetas(metaCond);
        request.setAttribute("links", metas);
        return "admin/links";
    }

    @ApiOperation("新增友情链接")
    @PostMapping(value = "/save")
    @ResponseBody
    public APIResponse addLink(
            @ApiParam(name = "title", value = "标签", required = true)
            @RequestParam(name = "title", required = true)
                    String title,
            @ApiParam(name = "url", value = "链接", required = true)
            @RequestParam(name = "url", required = true)
                    String url,
            @ApiParam(name = "logo", value = "logo", required = false)
            @RequestParam(name = "logo", required = false)
                    String logo,
            @ApiParam(name = "mid", value = "meta编号", required = false)
            @RequestParam(name = "mid", required = false)
                    Integer mid,
            @ApiParam(name = "sort", value = "sort", required = false)
            @RequestParam(name = "sort", required = false, defaultValue = "0")
                    int sort
    ) {
        try {
            Meta meta = new Meta();
            meta.setName(title);
            meta.setSlug(url);
            meta.setDescription(logo);
            meta.setSort(sort);
            meta.setType(Types.LINK.getType());
            if (null != mid) {
                meta.setMid(mid);
                metaService.updateMeta(meta);
            } else {
                metaService.addMea(meta);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw BusinessException.withErrorCode(ErrorConstant.Meta.ADD_META_FAIL);
        }

        return APIResponse.success();
    }

    @ApiOperation("删除友情链接")
    @PostMapping(value = "/delete")
    @ResponseBody
    public APIResponse deleteLink(
            @ApiParam(name = "mid", value = "meta主键", required = true)
            @RequestParam(name = "mid", required = true)
                    int mid
    ) {
        try {
            metaService.deleteMetaById(mid);
        } catch (Exception e) {
            e.printStackTrace();
            throw BusinessException.withErrorCode(ErrorConstant.Meta.DELETE_META_FAIL);
        }

        return APIResponse.success();
    }


}
