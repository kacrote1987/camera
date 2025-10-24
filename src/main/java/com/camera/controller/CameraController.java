package com.camera.controller;

import com.alibaba.fastjson.JSONArray;
import com.camera.config.Result;
import com.camera.entity.*;
import com.camera.service.CameraService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "万像慧治")
@RestController
@RequestMapping("/camera")
public class CameraController {
    @Resource
    CameraService cameraService;

    @ApiOperation("申请记录")
    @PostMapping("/applyList")
    public Result applyList(ApplyList params){
        PageInfo<ApplyList> applyList= cameraService.applyList(params);
        return Result.success(applyList);
    }

    @ApiOperation("申请记录详细")
    @PostMapping("/applyDet")
    public Result applyDet(@RequestBody Long applyId){
        List<ApplyDet> applyDet= cameraService.applyDet(applyId);
        return Result.success(applyDet);
    }

    @ApiOperation("申请点位清单")
    @PostMapping("/applyPoint")
    public Result applyPoint(@RequestParam Long applyId){
        List<ApplyPoint> applyPoint= cameraService.applyPoint(applyId);
        return Result.success(applyPoint);
    }

    @ApiOperation("申请记录保存")
    @PostMapping("/applyEdit")
    public Result applyEdit(Long applyId){
//        cameraService.applyEdit(applyId);
        return Result.success();
    }

    @ApiOperation("点位列表")
    @PostMapping("/cameralist")
    public Result cameraList(CameraList params){
        PageInfo<CameraList> cameraList= cameraService.cameraList(params);
        return Result.success(cameraList);
    }

    @ApiOperation("点位详细")
    @PostMapping("/cameradet")
    public Result cameraDet(@RequestBody String cameraId){
        List<CameraDet> cameraDet=cameraService.cameraDet(cameraId);
        return Result.success(cameraDet);
    }

    @ApiOperation("点位保存")
    @PostMapping("/camerasave")
    public Result cameraSave(@RequestBody CameraDet params){
        cameraService.cameraSave(params);
        return Result.success();
    }

    @ApiOperation("经纬度展示")
    @PostMapping("/lngLat")
    public Result lngLat(){
        double[][] lnglat=cameraService.lngLat();
        return Result.success(lnglat);
    }

    @ApiOperation("根据经纬度查点位详细")
    @PostMapping("/lnglatDet")
    public Result lnglatDet(@RequestBody String lngLat){
        List<CameraDet> cameraDet=cameraService.lnglatDet(lngLat);
        return Result.success(cameraDet);
    }

    @ApiOperation("可视域展示")
    @PostMapping("/lnglatDraw")
    public Result lnglatDraw(){
        List<LnglatDet> lnglatDraw=cameraService.lnglatDraw();
        return Result.success(lnglatDraw);
    }

    @ApiOperation("需求区域展示")
    @PostMapping("/areaDraw")
    public Result areaDraw(){
        List<JSONArray> areaDraw=cameraService.areaDraw();
        return Result.success(areaDraw);
    }

    @ApiOperation("需求区域保存")
    @PostMapping("/areasave")
    public Result areaSave(@RequestBody String params){
        cameraService.areaSave(params);
        return Result.success();
    }

    @ApiOperation("需求区域删除")
    @PostMapping("/areadel")
    public Result areaDel(@RequestBody String params){
        cameraService.areaDel(params);
        return Result.success();
    }

    @ApiOperation("标签列表")
    @PostMapping("/tagList")
    public Result tagList(TagList params){
        PageInfo<TagList> tagList= cameraService.tagList(params);
        return Result.success(tagList);
    }

    @ApiOperation("标签明细")
    @PostMapping("/tagDet")
    public Result tagDet(@RequestBody Long tagId){
        List<TagDetVo> tagDet= cameraService.tagDet(tagId);
        return Result.success(tagDet);
    }

    @ApiOperation("标签保存")
    @PostMapping("/tagsave")
    public Result tagSave(@RequestBody TagDetForm params){
        cameraService.tagSave(params);
        return Result.success();
    }

    @ApiOperation("标签集合")
    @PostMapping("/taggather")
    public Result tagGather(){
        String tagGather= cameraService.tagGather();
        return Result.success(tagGather);
    }

    @ApiOperation("待建数量")
    @PostMapping("/presave")
    public Result preSave(@RequestBody CameraList params){
        cameraService.preSave(params);
        return Result.success();
    }

    @ApiOperation("参数优先级")
    @PostMapping("/reqorder")
    public Result reqOrder(){
        List<TagDetVo> reqOrder= cameraService.reqOrder();
        return Result.success(reqOrder);
    }

    @ApiOperation("优先级保存")
    @PostMapping("/ordersave")
    public Result orderSave(@RequestBody GanttDet params){
        cameraService.orderSave(params);
        return Result.success();
    }

    @ApiOperation("参数要求")
    @PostMapping("/reqlist")
    public Result reqList(@RequestBody Long posId){
        List<TagDetVo> reqList= cameraService.reqList(posId);
        return Result.success(reqList);
    }

    @ApiOperation("设备选型库列表")
    @PostMapping("/paramList")
    public Result paramList(ParamList params){
        PageInfo<ParamList> paramList= cameraService.paramList(params);
        return Result.success(paramList);
    }

    @ApiOperation("设备选型库详细")
    @PostMapping("/paramDet")
    public Result paramDet(@RequestBody Long paramId){
        List<ParamList> paramDet= cameraService.paramDet(paramId);
        return Result.success(paramDet);
    }

    @ApiOperation("设备选型库修改")
    @PostMapping("/paramEdit")
    public Result paramEdit(@RequestBody ParamList params){
        cameraService.paramEdit(params);
        return Result.success();
    }

//    @ApiOperation("已选型号")
//    @PostMapping("/typeseled")
//    public Result typeSeled(@RequestBody String params){
//        List<TypeListForm> typeSeled= cameraService.typeSelected(params);
//        return Result.success(typeSeled);
//    }

    @ApiOperation("型号选择")
    @PostMapping("/typesel")
    public Result typeSel(@RequestBody String params){
        cameraService.typeSel(params);
        return Result.success();
    }

    @ApiOperation("规则库列表")
    @PostMapping("/ruleList")
    public Result ruleList(RuleList params){
        PageInfo<RuleList> ruleList= cameraService.ruleList(params);
        return Result.success(ruleList);
    }

    @ApiOperation("规则库详细")
    @PostMapping("/ruleDet")
    public Result ruleDet(@RequestBody Long ruleId){
        List<RuleList> ruleDet= cameraService.ruleDet(ruleId);
        return Result.success(ruleDet);
    }

    @ApiOperation("规则库修改")
    @PostMapping("/ruleEdit")
    public Result ruleEdit(@RequestBody RuleList params){
        cameraService.ruleEdit(params);
        return Result.success();
    }
}
