package com.wision.controller.prod;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.service.SuppService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "应用支撑体系")
@RestController
@RequestMapping("/supp")
public class ProdController {
    @Resource
    SuppService suppService;

    @ApiOperation("组件列表")
    @PostMapping("/toollist")
    public Result toolList(ToolListForm params){
        PageInfo<ToolListVo> toolList= suppService.toolList(params);
        return Result.success(toolList);
    }

    @ApiOperation("组件详细")
    @PostMapping("/tooldet")
    public Result toolDet(@RequestBody String params){
        List<ToolDetVo> toolDet= suppService.toolDet(params);
        return Result.success(toolDet);
    }

    @ApiOperation("组件保存")
    @PostMapping("/toolsave")
    public Result toolSave(@RequestBody ToolDetForm params){
        suppService.toolSave(params);
        return Result.success();
    }

    @ApiOperation("组件查询")
    @PostMapping("/toolsel")
    public Result toolSel(@RequestBody String prodId,ToolListForm params){
        PageInfo<ToolListVo> toolSel= suppService.toolSel(prodId,params);
        return Result.success(toolSel);
    }

    @ApiOperation("产品列表")
    @PostMapping("/prodlist")
    public Result prodList(ProdListForm params){
        PageInfo<ProdListVo> prodList= suppService.prodList(params);
        return Result.success(prodList);
    }

    @ApiOperation("产品详细")
    @PostMapping("/proddet")
    public Result prodDet(@RequestBody String params){
        List<ProdDetVo> prodDet= suppService.prodDet(params);
        return Result.success(prodDet);
    }

    @ApiOperation("产品保存")
    @PostMapping("/prodsave")
    public Result prodSave(@RequestBody ProdDetForm params){
        suppService.prodSave(params);
        return Result.success();
    }

    @ApiOperation("产品演示")
    @PostMapping("/prodview")
    public Result prodView(@RequestBody String params){
        List<ProdViewVo> prodView= suppService.prodView(params);
        return Result.success(prodView);
    }

    @ApiOperation("基础表保存")
    @PostMapping("/tblsave")
    public Result tblSave(@RequestBody BasicTblList params){
        suppService.tblSave(params);
        return Result.success();
    }

    @ApiOperation("基础表展示")
    @PostMapping("/basictbl")
    public Result basicTbl(@RequestBody String params){
        List<BasicTblList> basicTbl= suppService.basicTbl(params);
        return Result.success(basicTbl);
    }

    @ApiOperation("菜单列表")
    @PostMapping("/menulist")
    public Result menuList(@RequestBody String prodId){
        List<MenuListVo> menuList= suppService.menuList(prodId);
        return Result.suclayer(menuList);
    }

    @ApiOperation("菜单保存")
    @PostMapping("/menusave")
    public Result menuSave(@RequestBody MenuListForm params){
        suppService.menuSave(params);
        return Result.success();
    }

    @ApiOperation("菜单树")
    @PostMapping("/menutree")
    public Result menuTree(@RequestBody String params){
        List<MenuTreeVo> menuTree= suppService.menuTree(params);
        return Result.suclayer(menuTree);
    }

    @ApiOperation("流程组件列表")
    @PostMapping("/flowlist")
    public Result flowList(@RequestBody String params){
        List<FlowListVo> flowList= suppService.flowList(params);
        return Result.suclayer(flowList);
    }

    @ApiOperation("流程组件保存")
    @PostMapping("/flowsave")
    public Result flowSave(@RequestBody FlowListForm params){
        suppService.flowSave(params);
        return Result.success();
    }

    @ApiOperation("基础库表列表")
    @PostMapping("/tbllist")
    public Result tblList(@RequestBody String params){
        List<TblImpForm> tblList= suppService.tblList(params);
        return Result.success(tblList);
    }

    @ApiOperation("基础库表详细")
    @PostMapping("/tbldet")
    public Result tblDet(@RequestBody String params){
        List<TblImpForm> tblDet= suppService.tblDet(params);
        return Result.success(tblDet);
    }

    @ApiOperation("基础库表导入")
    @PostMapping("/basicimp")
    public Result basicImp(@RequestParam MultipartFile file, @RequestParam Long tblId,@RequestParam String tblCode) throws Exception {
        suppService.basicImp(file,tblId,tblCode);
        return Result.success();
    }

    @ApiOperation("组件映射信息列表")
    @PostMapping("/relatdet")
    public Result relatDet(@RequestBody Long relatId){
        List<RelatDetVo> relatDet= suppService.relatDet(relatId);
        return Result.suclayer(relatDet);
    }

    @ApiOperation("组件映射信息保存")
    @PostMapping("/relatsave")
    public Result relatSave(@RequestBody RelatForm params){
        suppService.relatSave(params);
        return Result.success();
    }

    @ApiOperation("自建表字段配置列表")
    @PostMapping("/basiccol")
    public Result basicCol(@RequestBody Long id){
        List<BasicCol> basicCol= suppService.basicCol(id);
        return Result.success(basicCol);
    }

    @ApiOperation("自建表字段配置保存")
    @PostMapping("/colsave")
    public Result colSave(@RequestBody BasicCol params){
        suppService.colSave(params);
        return Result.success();
    }

    @ApiOperation("子系统列名查看")
    @PostMapping("/childtblsel")
    public Result childTblSel(@RequestBody String menuId){
        List<ChildTblSelVo> childTblSel= suppService.childTblSel(menuId);
        return Result.success(childTblSel);
    }

    @ApiOperation("子系统主表查看")
    @PostMapping("/childtblcont")
    public Result childTblCont(@RequestBody String menuId,ChildTblForm params){
        PageInfo<ChildTblForm> childTblCont= suppService.childTblCont(menuId,params);
        return Result.success(childTblCont);
    }

    @ApiOperation("子系统详情页")
    @PostMapping("/childtbldet")
    public Result childTblDet(@RequestBody String params){
        ChildTblDetForm childTblDet= suppService.childTblDet(params);
        return Result.success(childTblDet);
    }

    @ApiOperation("流程关联主表")
    @PostMapping("/maintbl")
    public Result mainTbl(@RequestBody String params){
        List<MainTblVo> mainTbl= suppService.mainTbl(params);
        return Result.success(mainTbl);
    }

    @ApiOperation("工程计算器")
    @PostMapping("/calculator")
    public Result calculator(@RequestBody Calculator params){
        Float result= suppService.calculator(params);
        return Result.success(result);
    }
}
