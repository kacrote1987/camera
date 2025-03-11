package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.ProjService;
import com.wision.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "项目管理")
@RestController
@RequestMapping("/proj")
public class ProjController {
    @Resource
    ProjService projService;

    @ApiOperation("项目列表")
    @PostMapping("/projlist")
    public Result projList(ProjListForm params){
        PageInfo<ProjListForm> projList= projService.projList(params);
        return Result.success(projList);
    }
}
