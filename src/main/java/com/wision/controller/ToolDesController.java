package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.ToolDesService;
import com.wision.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "组件设计")
@RestController
@RequestMapping("/toolDes")
public class ToolDesController {
    @Resource
    ToolDesService toolDesService;

    @ApiOperation("组件列表")
    @PostMapping("/toolList")
    public Result toolList(ToolListForm params){
        PageInfo<ToolListVo> toolList= toolDesService.toolList(params);
        return Result.success(toolList);
    }

}
