package com.wision.controller;

import com.wision.config.Result;
import com.wision.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(description = "测试模块")
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @ApiOperation("二维码生成")
    @PostMapping("/qrcode")
    public Result qrcode(){
        testService.qrcode();
        return Result.success();
    }
}
