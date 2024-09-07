package com.wision.controller;

import com.wision.config.Result;
import com.wision.service.ChildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "子系统管理")
@RestController
@RequestMapping("/child")
public class ChildController {
    @Resource
    ChildService childService;

    @ApiOperation("子系统获取项目名称")
    @PostMapping("/getChildName")
    public Result getProdName(@RequestBody Long prodId){
        String getProdName= childService.getProdName(prodId);
        return Result.success(getProdName);
    }
}
