package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.config.Result;
import com.wision.entity.ChildMainVo;
import com.wision.entity.TblContVo;
import com.wision.service.ChildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @ApiOperation("获取子系统主要信息")
    @PostMapping("/getChildMain")
    public Result getChildMain(@RequestParam Long prodId){
        ChildMainVo childMain = childService.getChildMain(prodId);
        return Result.success(childMain);
    }

    @ApiOperation("子系统主表查看")
    @PostMapping("/tblCont")
    public Result tblCont(@RequestParam Long menuId){
        PageInfo<TblContVo> tblCont= childService.tblCont(menuId);
        return Result.success(tblCont);
    }

//    @ApiOperation("子系统主表查看")
//    @PostMapping("/tblCont")
//    public Result childTblCont(@RequestBody String menuId,ChildTblForm params){
//        PageInfo<ChildTblForm> childTblCont= prodService.childTblCont(menuId,params);
//        return Result.success(childTblCont);
//    }

//    @ApiOperation("子系统列名查看")
//    @PostMapping("/childtblsel")
//    public Result childTblSel(@RequestBody String menuId){
//        List<ChildTblSelVo> childTblSel= prodService.childTblSel(menuId);
//        return Result.success(childTblSel);
//    }

//    @ApiOperation("子系统详情页")
//    @PostMapping("/childtbldet")
//    public Result childTblDet(@RequestBody String params){
//        ChildTblDetForm childTblDet= prodService.childTblDet(params);
//        return Result.success(childTblDet);
//    }
}
