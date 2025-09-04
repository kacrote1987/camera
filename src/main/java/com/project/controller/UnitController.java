package com.project.controller;

import com.github.pagehelper.PageInfo;
import com.project.entity.UnitDetForm;
import com.project.entity.UnitListForm;
import com.project.entity.UnitDetVo;
import com.project.entity.UnitListVo;
import com.project.service.UnitService;
import com.project.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "单位管理")
@RestController
@RequestMapping("/unit")
public class UnitController {
    @Resource
    UnitService unitService;

    @ApiOperation("单位列表")
    @PostMapping("/unitlist")
    public Result unitList(UnitListForm params,@RequestBody String type){
        PageInfo<UnitListVo> unitList= unitService.unitList(params,type);
        return Result.success(unitList);
    }

    @ApiOperation("单位详细")
    @PostMapping("/unitdet")
    public Result unitDet(@RequestBody String unitId){
        List<UnitDetVo> unitDet= unitService.unitDet(unitId);
        return Result.success(unitDet);
    }

    @ApiOperation("单位保存")
    @PostMapping("/unitsave")
    public Result unitSave(@RequestBody UnitDetForm params){
        unitService.unitSave(params);
        return Result.success();
    }
}
