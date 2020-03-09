package lut.software.gavinoblog.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lut.software.gavinoblog.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/9 10:27
 */
@Api("文章管理")
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);


    @ApiOperation("文章页")
    @GetMapping(value = "")
    public String index() {
        return "admin/article_list";
    }

    @ApiOperation("发布新文章")
    @GetMapping(value = "/publish")
    public String newArticle() {
        return "admin/article_edit";
    }
}
