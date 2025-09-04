package com.project.controller;

import com.github.pagehelper.PageInfo;
import com.project.config.Result;
import com.project.entity.ApplyDetForm;
import com.project.entity.ApplyListForm;
import com.project.entity.ApplyStepForm;
import com.project.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "申请管理")
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    ApplyService applyService;

    @ApiOperation("申请单列表")
    @PostMapping("/applyList")
    public Result applyList(ApplyListForm params){
        PageInfo<ApplyListForm> applyList= applyService.applyList(params);
        return Result.success(applyList);
    }

    @ApiOperation("申请单详情")
    @PostMapping("/applyDet")
    public Result applyDet(@RequestBody Long applyId){
        List<ApplyDetForm> applyDet=applyService.applyDet(applyId);
        return Result.success(applyDet);
    }

    @ApiOperation("申请单新增")
    @PostMapping("/applyAdd")
    public Result applyAdd(@RequestBody ApplyDetForm params){
        applyService.applyAdd(params);
        return Result.success();
    }

    @ApiOperation("申请单流转")
    @PostMapping("/applyStep")
    public Result applyStep(@RequestBody ApplyStepForm params){
        applyService.applyStep(params);
        return Result.success();
    }
}
