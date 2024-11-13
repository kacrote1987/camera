package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.UnitDesService;
import com.wision.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(description = "组件设计")
@RestController
@RequestMapping("/toolDes")
public class UnitDesController {
    @Resource
    UnitDesService toolDesService;

    @ApiOperation("组件列表")
    @PostMapping("/toolList")
    public Result toolList(UnitListForm params){
        PageInfo<UnitListVo> toolList= toolDesService.toolList(params);
        return Result.success(toolList);
    }

}
