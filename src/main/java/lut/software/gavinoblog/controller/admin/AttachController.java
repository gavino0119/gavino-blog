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
 * @date 2020/3/9 11:29
 */
@Api("文件管理")
@Controller
@RequestMapping("admin/attach")
public class AttachController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachController.class);



    @ApiOperation("文件管理首页")
    @GetMapping(value = "")
    public String index() {
        return "admin/attach";
    }
}
