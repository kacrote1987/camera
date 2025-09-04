package com.project.controller;

import com.github.pagehelper.PageInfo;
import com.project.entity.*;
import com.project.service.ProjService;
import com.project.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("项目详细")
    @PostMapping("/projdet")
    public Result projDet(@RequestBody String projId){
        List<ProjDetForm> projDet= projService.projDet(projId);
        return Result.success(projDet);
    }

    @ApiOperation("项目保存")
    @PostMapping("/projsave")
    public Result projSave(@RequestBody ProjDetForm params){
        projService.projSave(params);
        return Result.success();
    }

    @ApiOperation("项目流转")
    @PostMapping("/projstep")
    public Result projStep(@RequestBody ProjListForm params){
        projService.projStep(params);
        return Result.success();
    }

    @ApiOperation("后项项目列表")
    @PostMapping("/conseqlist")
    public Result conseqList(@RequestBody String params){
        PageInfo<ConseqList> conseqList= projService.conseqList(params);
        return Result.success(conseqList);
    }

    @ApiOperation("后项项目详细")
    @PostMapping("/conseqdet")
    public Result conseqDet(@RequestBody String conseqId){
        List<ConseqDet> conseqList= projService.conseqDet(conseqId);
        return Result.success(conseqList);
    }

    @ApiOperation("后项项目保存")
    @PostMapping("/conseqsave")
    public Result conseqSave(@RequestBody ConseqDet params){
        projService.conseqSave(params);
        return Result.success();
    }

    @ApiOperation("项目资产列表")
    @PostMapping("/assproj")
    public Result assProj(@RequestBody String params){
        List<AssProj> assProj=projService.assProj(params);
        return Result.success(assProj);
    }

    @ApiOperation("成本管理")
    @PostMapping("/projcost")
    public Result projCost(@RequestBody String params){
        List<ProjCostForm> projCost= projService.projCost(params);
        return Result.success(projCost);
    }

    @ApiOperation("例会列表")
    @PostMapping("/meetlist")
    public Result meetList(@RequestBody MeetListForm params){
        PageInfo<MeetListForm> meetList= projService.meetList(params);
        return Result.success(meetList);
    }

    @ApiOperation("例会详细")
    @PostMapping("/meetdet")
    public Result meetDet(@RequestBody String projId){
        List<MeetDetForm> meetDet= projService.meetDet(projId);
        return Result.success(meetDet);
    }

    @ApiOperation("例会保存")
    @PostMapping("/meetsave")
    public Result meetSave(@RequestBody MeetDetForm params){
        projService.meetSave(params);
        return Result.success();
    }

    @ApiOperation("甘特图详细")
    @PostMapping("/ganttdet")
    public Result ganttDet(@RequestBody String params){
        List<GanttDetForm> ganttDet=projService.ganttDet(params);
        return Result.success(ganttDet);
    }

    @ApiOperation("甘特图保存")
    @PostMapping("/ganttdo")
    public Result ganttDo(@RequestBody GanttDetForm params){
        projService.ganttDo(params);
        return Result.success();
    }

    @ApiOperation("甘特图展示")
    @PostMapping("/ganttdisp")
    public Result ganttDisp(@RequestBody Long projId){
        List<GanttDispForm> ganttDisp=projService.ganttDisp(projId);
        return Result.success(ganttDisp);
    }

    @ApiOperation("生成日志")
    @PostMapping("/ganttlog")
    public Result ganttLog(@RequestBody Long projId){
        projService.ganttLog(projId);
        return Result.success();
    }
}
