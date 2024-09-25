package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.config.Result;
import com.wision.entity.*;
import com.wision.service.ToolDesService;
import com.wision.service.ToolStoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "组件商店")
@RestController
@RequestMapping("/toolSto")
public class ToolStoController {
    @Resource
    ToolStoService toolStoService;

    @ApiOperation("组件列表")
    @PostMapping("/toolList")
    public Result toolList(ToolListForm params){
        PageInfo<ToolListVo> toolList= toolStoService.toolList(params);
        return Result.success(toolList);
    }

    @ApiOperation("组件详细")
    @PostMapping("/toolDet")
    public Result toolDet(@RequestBody String params){
        List<ToolDetVo> toolDet= toolStoService.toolDet(params);
        return Result.success(toolDet);
    }

    @ApiOperation("组件保存")
    @PostMapping("/toolSave")
    public Result toolSave(@RequestBody ToolDetForm params){
        toolStoService.toolSave(params);
        return Result.success();
    }

    @ApiOperation("组件配置-基础信息组件-数据源字典")
    @PostMapping("/basicSour")
    public Result basicSour(@RequestParam Long relatId){
        BasicSourVo basicSour= toolStoService.basicSour(relatId);
        return Result.success(basicSour);
    }

    @ApiOperation("组件配置-基础信息组件-组件设置")
    @PostMapping("/basicCond")
    public Result basicCond(@RequestParam Long relatId){
        List<BasicCondVo> basicCond= toolStoService.basicCond(relatId);
        return Result.success(basicCond);
    }

    @ApiOperation("组件配置-基础信息组件-配置修改")
    @PostMapping("/basicCondEdit")
    public Result basicCondEdit(@RequestBody BasicCondForm1 params){
        toolStoService.basicCondEdit(params);
        return Result.success();
    }

    @ApiOperation("组件配置-基础信息组件-条件新增")
    @PostMapping("/basicCondAdd")
    public Result basicCondAdd(@RequestBody BasicCondForm2 params){
        toolStoService.basicCondAdd(params);
        return Result.success();
    }

    @ApiOperation("组件展示-基础信息组件-本表字段字典")
    @PostMapping("/basicView")
    public Result basicView(@RequestParam Long relatId){
        List<BasicCol> basicView= toolStoService.basicView(relatId);
        return Result.success(basicView);
    }

    @ApiOperation("组件配置-基础信息组件-条件设置删除")
    @PostMapping("/basicCondDel")
    public Result basicCondDel(@RequestParam Long ruleId){
        toolStoService.basicCondDel(ruleId);
        return Result.success();
    }

    @ApiOperation("组件配置-流程组件-配置列表")
    @PostMapping("/flowCond")
    public Result flowCond(@RequestParam Long relatId){
        FlowCondVo flowCond= toolStoService.flowCond(relatId);
        return Result.success(flowCond);
    }

    @ApiOperation("组件配置-流程组件-配置修改")
    @PostMapping("/flowCondEdit")
    public Result flowCondEdit(@RequestBody FlowCondForm params){
        toolStoService.flowCondEdit(params);
        return Result.success();
    }

    @ApiOperation("组件展示-流程组件")
    @PostMapping("/flowView")
    public Result flowView(@RequestParam Long relatId){
        List<FlowViewVo> flowView= toolStoService.flowView(relatId);
        return Result.success(flowView);
    }

    @ApiOperation("组件展示-流程组件-流程项新增")
    @PostMapping("/flowAdd")
    public Result flowAdd(@RequestParam Long relatId){
        toolStoService.flowAdd(relatId);
        return Result.success();
    }

    @ApiOperation("组件展示-流程组件-流程项删除")
    @PostMapping("/flowDel")
    public Result flowDel(@RequestParam Long extId){
        toolStoService.flowDel(extId);
        return Result.success();
    }

    @ApiOperation("组件展示-流程组件-流程项修改")
    @PostMapping("/flowEdit")
    public Result flowEdit(@RequestBody FlowListForm params){
        toolStoService.flowEdit(params);
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
}
