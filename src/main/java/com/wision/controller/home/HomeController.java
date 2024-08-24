package com.wision.controller.home;

import com.wision.entity.DocListVo;
import com.wision.service.HomeService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "主页管理")
@RestController
@RequestMapping("/home")
public class HomeController {
    @Resource
    HomeService homeService;

    @ApiOperation("主页展示")
    @PostMapping("/homedisply")
    public Result homeDisplay(@RequestBody String params){
        List<DocListVo> homeDisplay= homeService.homeDisplay(params);
        return Result.success(homeDisplay);
    }
}
