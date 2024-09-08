package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.config.Result;
import com.wision.entity.ChildMainVo;
import com.wision.entity.ChildTblForm;
import com.wision.entity.MainContVo;
import com.wision.entity.MainSelVo;
import com.wision.service.ChildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "子系统管理")
@RestController
@RequestMapping("/child")
public class ChildController {
    @Resource
    ChildService childService;

    @ApiOperation("获取子系统项目名称")
    @PostMapping("/getChildName")
    public Result getChildName(@RequestParam Long prodId){
        String childName= childService.getChildName(prodId);
        return Result.success(childName);
    }

    @ApiOperation("获取子系统主要菜单")
    @PostMapping("/getChildMain")
    public Result getChildMain(@RequestParam Long prodId){
        ChildMainVo childMain = childService.getChildMain(prodId);
        return Result.success(childMain);
    }

    @ApiOperation("子系统列名查看")
    @PostMapping("/mainSel")
    public Result mainSel(@RequestParam Long menuId){
        List<MainSelVo> mainSel= childService.mainSel(menuId);
        return Result.success(mainSel);
    }

    @ApiOperation("子系统主表查看")
    @PostMapping("/mainCont")
    public Result mainCont(@RequestParam Long menuId, ChildTblForm params){
        PageInfo<MainContVo> mainCont= childService.mainCont(menuId,params);
        return Result.success(mainCont);
    }

//    @ApiOperation("子系统详情页")
//    @PostMapping("/childtbldet")
//    public Result childTblDet(@RequestBody String params){
//        ChildTblDetForm childTblDet= prodService.childTblDet(params);
//        return Result.success(childTblDet);
//    }
}
