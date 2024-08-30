package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.ProdService;
import com.wision.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "产品管理")
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
    public Result prodDel(@RequestParam Long prodId){
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
    @PostMapping("/menuList")
    public Result menuList(@RequestParam Long prodId){
        List<MenuListVo> menuList= prodService.menuList(prodId);
        return Result.success(menuList);
    }

    @ApiOperation("菜单新增")
    @PostMapping("/menuAdd")
    public Result menuAdd(@RequestParam Long prodId){
        prodService.menuAdd(prodId);
        return Result.success();
    }

    @ApiOperation("菜单删除")
    @PostMapping("/menuDel")
    public Result menuDel(@RequestParam Long menuId){
        prodService.menuDel(menuId);
        return Result.success();
    }

    @ApiOperation("菜单修改")
    @PostMapping("/menuEdit")
    public Result menuSave(@RequestBody MenuEditForm params){
        prodService.menuEdit(params);
        return Result.success();
    }

    @ApiOperation("菜单树")
    @PostMapping("/menuTree")
    public Result menuTree(@RequestParam Long prodId){
        List<MenuTreeVo> menuTree= prodService.menuTree(prodId);
        return Result.success(menuTree);
    }

    @ApiOperation("根据菜单树查组件")
    @PostMapping("/toolSel")
    public Result toolSel(@RequestBody String prodId,ToolListForm params){
        PageInfo<ToolListVo> toolSel= prodService.toolSel(prodId,params);
        return Result.success(toolSel);
    }

    @ApiOperation("基础信息组件配置")
    @PostMapping("/basicConf")
    public Result basicConf(@RequestParam Long relatId){
        RelatDetVo basicConf= prodService.basicConf(relatId);
        return Result.success(basicConf);
    }

    @ApiOperation("基础信息组件展示")
    @PostMapping("/basicView")
    public Result basicView(@RequestParam Long relatId){
        List<BasicTblList> basicView= prodService.basicView(relatId);
        return Result.success(basicView);
    }

//    @ApiOperation("组件配置修改")
//    @PostMapping("/relatEdit")
//    public Result relatSave(@RequestBody RelatForm params){
//        prodService.relatSave(params);
//        return Result.success();
//    }

//    @ApiOperation("基础表保存")
//    @PostMapping("/tblsave")
//    public Result tblSave(@RequestBody BasicTblList params){
//        prodService.tblSave(params);
//        return Result.success();
//    }
//
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
