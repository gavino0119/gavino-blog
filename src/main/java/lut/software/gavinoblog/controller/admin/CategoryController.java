package lut.software.gavinoblog.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lut.software.gavinoblog.common.utils.ResultResponse;
import lut.software.gavinoblog.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2020/3/9 11:46
 */
@Api("分类管理")
@Controller
@RequestMapping("/admin/category")
public class CategoryController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);


    @ApiOperation("进入分类和标签页")
    @GetMapping(value = "")
    public String index() {
        return "admin/category";

    }

    @ApiOperation("保存分类")
    @PostMapping(value = "/save")
    @ResponseBody
    public ResultResponse addCategory(
            @ApiParam(name = "cname", value = "分类名", required = true)
            @RequestParam(name = "cname", required = true)
                    String cname,
            @ApiParam(name = "mid", value = "meta编号", required = false)
            @RequestParam(name = "mid", required = false)
                    Integer mid
    ) {




        return ResultResponse.success();
    }
}
