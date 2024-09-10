package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.ToolService;
import com.wision.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("基础信息组件-组件配置-数据源字典")
    @PostMapping("/basicSour")
    public Result basicSour(@RequestParam Long relatId){
        BasicSourVo basicSour= toolService.basicSour(relatId);
        return Result.success(basicSour);
    }

    @ApiOperation("基础信息组件-条件设置列表")
    @PostMapping("/basicCond")
    public Result basicCond(@RequestParam Long relatId){
        List<BasicCondVo> basicCond= toolService.basicCond(relatId);
        return Result.success(basicCond);
    }

    @ApiOperation("基础信息组件-条件设置字典+组件展示")
    @PostMapping("/basicView")
    public Result basicView(@RequestParam Long relatId){
        List<BasicCol> basicView= toolService.basicView(relatId);
        return Result.success(basicView);
    }

    @ApiOperation("基础信息组件-条件设置新增")
    @PostMapping("/basicCondAdd")
    public Result basicCondAdd(@RequestBody Long params){
        toolService.basicCondAdd(params);
        return Result.success();
    }

    @ApiOperation("基础信息组件-条件设置删除")
    @PostMapping("/basicCondDel")
    public Result basicCondDel(@RequestParam Long ruleId){
        toolService.basicCondDel(ruleId);
        return Result.success();
    }

//    @ApiOperation("规则配置字典")
//    @PostMapping("/ruleDict")
//    public Result ruleDict(@RequestParam Long relatId){
//        RuleDictVo ruleDict= toolService.ruleDict(relatId);
//        return Result.success(ruleDict);
//    }
//
//    @ApiOperation("规则配置新增")
//    @PostMapping("/ruleAdd")
//    public Result ruleAdd(@RequestBody RuleListForm params){
//        toolService.ruleAdd(params);
//        return Result.success();
//    }
//
//    @ApiOperation("组件数据源详细")
//    @PostMapping("/sourDet")
//    public Result sourDet(@RequestParam Long relatId){
//        SourDetVo sourDet= toolService.sourDet(relatId);
//        return Result.success(sourDet);
//    }
//
//    @ApiOperation("组件布局修改")
//    @PostMapping("/layoutEdit")
//    public Result layoutEdit(@RequestBody RelatForm params){
//        toolService.layoutEdit(params);
//        return Result.success();
//    }
//
//    @ApiOperation("组件数据源修改")
//    @PostMapping("/sourEdit")
//    public Result sourEdit(@RequestBody RelatForm params){
//        toolService.sourEdit(params);
//        return Result.success();
//    }

//      <分割线>

//    @ApiOperation("组件展示-流程组件")
//    @PostMapping("/flowView")
//    public Result flowView(@RequestParam Long relatId){
//        List<FlowViewVo> flowView= toolService.flowView(relatId);
//        return Result.success(flowView);
//    }
//
//    @ApiOperation("流程组件-流程项新增")
//    @PostMapping("/flowAdd")
//    public Result flowAdd(@RequestParam Long relatId){
//        toolService.flowAdd(relatId);
//        return Result.success();
//    }
//
//    @ApiOperation("流程组件-流程项删除")
//    @PostMapping("/flowDel")
//    public Result flowDel(@RequestParam Long extId){
//        toolService.flowDel(extId);
//        return Result.success();
//    }
//
//    @ApiOperation("流程组件-流程项修改")
//    @PostMapping("/flowEdit")
//    public Result flowEdit(@RequestBody FlowListForm params){
//        toolService.flowEdit(params);
//        return Result.success();
//    }
}
