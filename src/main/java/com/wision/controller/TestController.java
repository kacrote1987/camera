package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.config.Result;
import com.wision.entity.*;
import com.wision.service.TestService;
import com.wision.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(description = "测试模块")
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @ApiOperation("测试置空")
    @PostMapping("/empty")
    public Result empty(){
        return Result.success("null");
    }
    @ApiOperation("二维码生成")
    @PostMapping("/qrcode")
    public Result qrcode(){
        testService.qrcode();
        return Result.success();
    }
}
