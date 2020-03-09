package lut.software.gavinoblog.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lut.software.gavinoblog.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/8 20:35
 */
@Api("后台首页")
@Controller("adminIndexController")
@RequestMapping(value = "/admin")
public class IndexController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    @ApiOperation("进入首页")
    @GetMapping(value = {"","/index"})
    public String index(HttpServletRequest request) {
        LOGGER.info("Enter admin index method");


        LOGGER.info("Exit admin index method");
        return "admin/index";
    }
}
