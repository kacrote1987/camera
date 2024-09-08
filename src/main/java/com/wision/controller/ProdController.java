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
        List<SourDictVo> tblList= prodService.tblList(prodId);
        return Result.success(tblList);
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
        PageInfo<ToolSelVo> toolSel= prodService.toolSel(prodId,params);
        return Result.success(toolSel);
    }

    @ApiOperation("规则配置列表")
    @PostMapping("/ruleList")
    public Result ruleList(@RequestParam Long relatId){
        List<RuleListVo> ruleList= prodService.ruleList(relatId);
        return Result.success(ruleList);
    }

    @ApiOperation("规则配置字典")
    @PostMapping("/ruleDict")
    public Result ruleDict(@RequestParam Long relatId){
        RuleDictVo ruleDict= prodService.ruleDict(relatId);
        return Result.success(ruleDict);
    }

    @ApiOperation("规则配置新增")
    @PostMapping("/ruleAdd")
    public Result ruleAdd(@RequestBody RuleListForm params){
        prodService.ruleAdd(params);
        return Result.success();
    }

    @ApiOperation("组件数据源详细")
    @PostMapping("/sourDet")
    public Result sourDet(@RequestParam Long relatId){
        SourDetVo sourDet= prodService.sourDet(relatId);
        return Result.success(sourDet);
    }

    @ApiOperation("组件布局修改")
    @PostMapping("/layoutEdit")
    public Result layoutEdit(@RequestBody RelatForm params){
        prodService.layoutEdit(params);
        return Result.success();
    }

    @ApiOperation("组件数据源修改")
    @PostMapping("/sourEdit")
    public Result sourEdit(@RequestBody RelatForm params){
        prodService.sourEdit(params);
        return Result.success();
    }

    @ApiOperation("组件数据源字典")
    @PostMapping("/sourDict")
    public Result sourDict(@RequestParam Long relatId){
        List<SourDictVo> sourDict= prodService.sourDict(relatId);
        return Result.success(sourDict);
    }

    @ApiOperation("组件展示-基础信息组件")
    @PostMapping("/basicView")
    public Result basicView(@RequestParam Long relatId){
        List<BasicCol> basicView= prodService.basicView(relatId);
        return Result.success(basicView);
    }

    @ApiOperation("组件展示-流程组件")
    @PostMapping("/flowView")
    public Result flowView(@RequestParam Long relatId){
        List<FlowViewVo> flowView= prodService.flowView(relatId);
        return Result.success(flowView);
    }

    @ApiOperation("流程组件-流程项新增")
    @PostMapping("/flowAdd")
    public Result flowAdd(@RequestParam Long relatId){
        prodService.flowAdd(relatId);
        return Result.success();
    }

    @ApiOperation("流程组件-流程项删除")
    @PostMapping("/flowDel")
    public Result flowDel(@RequestParam Long extId){
        prodService.flowDel(extId);
        return Result.success();
    }

    @ApiOperation("流程组件-流程项修改")
    @PostMapping("/flowEdit")
    public Result flowEdit(@RequestBody FlowListForm params){
        prodService.flowEdit(params);
        return Result.success();
    }

    @ApiOperation("授权信息设置")
    @PostMapping("/authorize")
    public Result authorize(@RequestParam Long prodId){
        prodService.authorize(prodId);
        return Result.success();
    }

    @ApiOperation("代码自动生成")
    @PostMapping("/generate")
    public Result generate(@RequestParam Long prodId){
        prodService.generate(prodId);
        return Result.success();
    }

//    @ApiOperation("基础表保存")
//    @PostMapping("/tblsave")
//    public Result tblSave(@RequestBody BasicTblList params){
//        prodService.tblSave(params);
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
//    @ApiOperation("流程关联主表")
//    @PostMapping("/maintbl")
//    public Result mainTbl(@RequestBody String params){
//        List<MainTblVo> mainTbl= prodService.mainTbl(params);
//        return Result.success(mainTbl);
//    }
}
