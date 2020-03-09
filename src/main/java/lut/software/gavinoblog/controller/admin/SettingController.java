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
 * @date 2020/3/9 12:45
 */
@Api("系统设置管理")
@Controller
@RequestMapping("admin/setting")
public class SettingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);


    @ApiOperation("进入设置页")
    @GetMapping(value = "")
    public String index() {
        return "admin/setting";
    }


}
