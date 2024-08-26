package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.ProdService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "产品关联")
@RestController
@RequestMapping("/prod")
public class ProdController {
    @Resource
    ProdService prodService;

    @ApiOperation("产品上架列表")
    @PostMapping("/prodList")
    public Result prodList(ProdListForm params){
        PageInfo<ProdListVo> prodList= prodService.prodList(params);
        return Result.success(prodList);
    }

    @ApiOperation("产品详细")
    @PostMapping("/prodDet")
    public Result prodDet(@RequestBody Long prodId){
        List<ProdDetVo> prodDet= prodService.prodDet(prodId);
        return Result.success(prodDet);
    }

    @ApiOperation("产品上下架")
    @PostMapping("/changeState")
    public Result changeState(@RequestBody ProdStateForm params){
        prodService.changeState(params);
        return Result.success();
    }

    @ApiOperation("产品设计列表")
    @PostMapping("/prodDesign")
    public Result prodDesign(ProdDesignForm params){
        PageInfo<ProdDesignVo> prodDesign= prodService.prodDesign(params);
        return Result.success(prodDesign);
    }

    @ApiOperation("产品新增")
    @PostMapping("/prodAdd")
    public Result prodAdd(@RequestBody ProdDetForm params){
        prodService.prodAdd(params);
        return Result.success();
    }

    @ApiOperation("产品删除")
    @PostMapping("/prodDel")
    public Result prodDel(@RequestBody Long prodId){
        prodService.prodDel(prodId);
        return Result.success();
    }

    @ApiOperation("产品修改")
    @PostMapping("/prodEdit")
    public Result prodEdit(@RequestBody ProdDetForm params){
        prodService.prodEdit(params);
        return Result.success();
    }

    @ApiOperation("库表列表")
    @PostMapping("/tblList")
    public Result tblList(@RequestParam Long prodId){
        List<TblListVo> tblList= prodService.tblList(prodId);
        return Result.success(tblList);
    }

    @ApiOperation("子系统获取项目名称")
    @PostMapping("/getProdName")
    public Result getProdName(@RequestBody Long prodId){
        String getProdName= prodService.getProdName(prodId);
        return Result.success(getProdName);
    }

    @ApiOperation("菜单列表")
    @PostMapping("/menulist")
    public Result menuList(@RequestParam Long prodId){
        List<MenuListVo> menuList= prodService.menuList(prodId);
        return Result.success(menuList);
    }

//    @ApiOperation("基础表保存")
//    @PostMapping("/tblsave")
//    public Result tblSave(@RequestBody BasicTblList params){
//        prodService.tblSave(params);
//        return Result.success();
//    }
//
//    @ApiOperation("基础表展示")
//    @PostMapping("/basictbl")
//    public Result basicTbl(@RequestBody String params){
//        List<BasicTblList> basicTbl= prodService.basicTbl(params);
//        return Result.success(basicTbl);
//    }
//
//
//    @ApiOperation("菜单保存")
//    @PostMapping("/menusave")
//    public Result menuSave(@RequestBody MenuListForm params){
//        prodService.menuSave(params);
//        return Result.success();
//    }
//
//    @ApiOperation("菜单树")
//    @PostMapping("/menutree")
//    public Result menuTree(@RequestBody String params){
//        List<MenuTreeVo> menuTree= prodService.menuTree(params);
//        return Result.suclayer(menuTree);
//    }
//
//    @ApiOperation("流程组件列表")
//    @PostMapping("/flowlist")
//    public Result flowList(@RequestBody String params){
//        List<FlowListVo> flowList= prodService.flowList(params);
//        return Result.suclayer(flowList);
//    }
//
//    @ApiOperation("流程组件保存")
//    @PostMapping("/flowsave")
//    public Result flowSave(@RequestBody FlowListForm params){
//        prodService.flowSave(params);
//        return Result.success();
//    }
//
//    @ApiOperation("基础库表列表")
//    @PostMapping("/tbllist")
//    public Result tblList(@RequestBody String params){
//        List<TblImpForm> tblList= prodService.tblList(params);
//        return Result.success(tblList);
//    }
//
//    @ApiOperation("基础库表详细")
//    @PostMapping("/tbldet")
//    public Result tblDet(@RequestBody String params){
//        List<TblImpForm> tblDet= prodService.tblDet(params);
//        return Result.success(tblDet);
//    }
//
//    @ApiOperation("基础库表导入")
//    @PostMapping("/basicimp")
//    public Result basicImp(@RequestParam MultipartFile file, @RequestParam Long tblId,@RequestParam String tblCode) throws Exception {
//        prodService.basicImp(file,tblId,tblCode);
//        return Result.success();
//    }
//
//    @ApiOperation("组件映射信息列表")
//    @PostMapping("/relatdet")
//    public Result relatDet(@RequestBody Long relatId){
//        List<RelatDetVo> relatDet= prodService.relatDet(relatId);
//        return Result.suclayer(relatDet);
//    }
//
//    @ApiOperation("组件映射信息保存")
//    @PostMapping("/relatsave")
//    public Result relatSave(@RequestBody RelatForm params){
//        prodService.relatSave(params);
//        return Result.success();
//    }
//
//    @ApiOperation("自建表字段配置列表")
//    @PostMapping("/basiccol")
//    public Result basicCol(@RequestBody Long id){
//        List<BasicCol> basicCol= prodService.basicCol(id);
//        return Result.success(basicCol);
//    }
//
//    @ApiOperation("自建表字段配置保存")
//    @PostMapping("/colsave")
//    public Result colSave(@RequestBody BasicCol params){
//        prodService.colSave(params);
//        return Result.success();
//    }
//
//    @ApiOperation("子系统列名查看")
//    @PostMapping("/childtblsel")
//    public Result childTblSel(@RequestBody String menuId){
//        List<ChildTblSelVo> childTblSel= prodService.childTblSel(menuId);
//        return Result.success(childTblSel);
//    }
//
//    @ApiOperation("子系统主表查看")
//    @PostMapping("/childtblcont")
//    public Result childTblCont(@RequestBody String menuId,ChildTblForm params){
//        PageInfo<ChildTblForm> childTblCont= prodService.childTblCont(menuId,params);
//        return Result.success(childTblCont);
//    }
//
//    @ApiOperation("子系统详情页")
//    @PostMapping("/childtbldet")
//    public Result childTblDet(@RequestBody String params){
//        ChildTblDetForm childTblDet= prodService.childTblDet(params);
//        return Result.success(childTblDet);
//    }
//
//    @ApiOperation("流程关联主表")
//    @PostMapping("/maintbl")
//    public Result mainTbl(@RequestBody String params){
//        List<MainTblVo> mainTbl= prodService.mainTbl(params);
//        return Result.success(mainTbl);
//    }
}
