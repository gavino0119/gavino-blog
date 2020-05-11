package lut.software.gavinoblog.controller.admin;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lut.software.gavinoblog.common.utils.APIResponse;
import lut.software.gavinoblog.controller.BaseController;
import lut.software.gavinoblog.dto.cond.CommentCond;
import lut.software.gavinoblog.pojo.Comment;
import lut.software.gavinoblog.pojo.User;
import lut.software.gavinoblog.service.comment.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/31 20:36
 */
@Api("评论相关接口")
@Controller
@RequestMapping("/admin/comments")
public class CommentController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @ApiOperation("进入评论列表页")
    @GetMapping(value = "")
    public String index(
            @ApiParam(name = "page", value = "页数", required = false)
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int page,
            @ApiParam(name = "limit", value = "每页条数", required = false)
            @RequestParam(name = "limit", required = false, defaultValue = "15")
                    int limit,
            HttpServletRequest request

    ) {
        User user = this.user(request);
        PageInfo<Comment> comments = commentService.getCommentsByCond(new CommentCond(), page, limit);
        request.setAttribute("comments", comments);
        return "admin/comment_list";
    }

    @ApiOperation("审核评论")
    @PostMapping(value = "/status")
    @ResponseBody
    public APIResponse changeStatus(
            HttpServletRequest request,
            @ApiParam(name = "coid", value = "评论主键", required = true)
            @RequestParam(name = "coid", required = true)
                    Integer coid,
            @ApiParam(name = "status", value = "状态", required = true)
            @RequestParam(name = "status", required = true)
                    String status
    ) {
        try {
            Comment comment = commentService.getCommentById(coid);
            if (null != comment) {
                commentService.updateCommentStatus(coid,status);
            } else {
                return APIResponse.fail("通过失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            return APIResponse.fail(e.getMessage());
        }
        return APIResponse.success();
    }
    @ApiOperation("删除评论")
    @PostMapping(value = "/delete")
    @ResponseBody
    public APIResponse deleteStatus(
            HttpServletRequest request,
            @ApiParam(name = "coid", value = "评论主键", required = true)
            @RequestParam(name = "coid", required = true)
                    Integer coid
    ) {
        try {
            Comment comment = commentService.getCommentById(coid);
            if (null != comment) {
                commentService.deleteComment(coid);
            } else {
                return APIResponse.fail("通过失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            return APIResponse.fail(e.getMessage());
        }
        return APIResponse.success();
    }
}