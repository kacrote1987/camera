package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ToolDetForm;
import com.wision.entity.ToolDetVo;
import com.wision.entity.ToolListForm;
import com.wision.entity.ToolListVo;
import com.wision.service.ToolService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "组件管理")
@RestController
@RequestMapping("/tool")
public class ToolController {
    @Resource
    ToolService toolService;

    @ApiOperation("组件列表")
    @PostMapping("/toolList")
    public Result toolList(ToolListForm params){
        PageInfo<ToolListVo> toolList= toolService.toolList(params);
        return Result.success(toolList);
    }

    @ApiOperation("组件详细")
    @PostMapping("/toolDet")
    public Result toolDet(@RequestBody String params){
        List<ToolDetVo> toolDet= toolService.toolDet(params);
        return Result.success(toolDet);
    }

    @ApiOperation("组件保存")
    @PostMapping("/toolSave")
    public Result toolSave(@RequestBody ToolDetForm params){
        toolService.toolSave(params);
        return Result.success();
    }
}
