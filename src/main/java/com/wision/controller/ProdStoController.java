package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.config.Result;
import com.wision.entity.*;
import com.wision.service.ProdStoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "产品商店")
@RestController
@RequestMapping("/prodSto")
public class ProdStoController {
    @Resource
    ProdStoService prodStoService;

    @ApiOperation("产品列表")
    @PostMapping("/prodList")
    public Result prodList(ProdListForm params){
        PageInfo<ProdListVo> prodList= prodStoService.prodList(params);
        return Result.success(prodList);
    }

    @ApiOperation("产品详细")
    @PostMapping("/prodDet")
    public Result prodDet(@RequestBody Long prodId){
        List<ProdDetVo> prodDet= prodStoService.prodDet(prodId);
        return Result.success(prodDet);
    }

    @ApiOperation("产品下架")
    @PostMapping("/offLine")
    public Result offLine(@RequestParam Long prodId){
        prodStoService.offLine(prodId);
        return Result.success();
    }

    @ApiOperation("获取子系统项目名称")
    @PostMapping("/getChildName")
    public Result getChildName(@RequestParam Long prodId){
        String childName= prodStoService.getChildName(prodId);
        return Result.success(childName);
    }

    @ApiOperation("获取子系统主要菜单")
    @PostMapping("/getChildMain")
    public Result getChildMain(@RequestParam Long prodId){
        ChildMainVo childMain = prodStoService.getChildMain(prodId);
        return Result.success(childMain);
    }

    @ApiOperation("子系统列名查看")
    @PostMapping("/mainSel")
    public Result mainSel(@RequestParam Long menuId){
        List<MainSelVo> mainSel= prodStoService.mainSel(menuId);
        return Result.success(mainSel);
    }

    @ApiOperation("子系统主表查看")
    @PostMapping("/mainCont")
    public Result mainCont(@RequestParam Long menuId, ChildTblForm params){
        PageInfo<MainContVo> mainCont= prodStoService.mainCont(menuId,params);
        return Result.success(mainCont);
    }

//    @ApiOperation("子系统详情页")
//    @PostMapping("/childtbldet")
//    public Result childTblDet(@RequestBody String params){
//        ChildTblDetForm childTblDet= prodService.childTblDet(params);
//        return Result.success(childTblDet);
//    }

    @ApiOperation("代码自动生成")
    @PostMapping("/generate")
    public Result generate(@RequestParam Long prodId){
        prodStoService.generate(prodId);
        return Result.success();
    }
}
