package com.wision.controller;

import com.wision.service.UserService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(description = "错误")
@RestController
@RequestMapping()
public class ErrorController {
    @Resource
    UserService userService;

    @ApiOperation("错误")
    @PostMapping("/error")
    public Result error() {
        return Result.failed("错误");
    }
}
