package com.wision.controller;

import com.wision.config.Result;
import com.wision.service.ToolStoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "小工具库")
@RestController
@RequestMapping("/toolSto")
public class ToolStoController {
    @Resource
    ToolStoService toolStoService;

    @ApiOperation("二维码生成")
    @PostMapping("/qrcode")
    public Result qrcode(){
        toolStoService.qrcode();
        return Result.success();
    }

    @ApiOperation("微信扫码支付")
    @PostMapping("/payByWx")
    public Result payByWx(){
        toolStoService.payByWx();
        return Result.success();
    }

    @ApiOperation("kafka")
    @PostMapping("/kafka")
    public Result kafka(){
        toolStoService.kafka();
        return Result.success();
    }
}
