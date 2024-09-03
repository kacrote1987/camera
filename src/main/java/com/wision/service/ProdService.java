package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ProdService {
    /**
     * 产品上架列表
     * @return
     */
    PageInfo<ProdListVo> prodList(ProdListForm params);
    /**
     * 产品详细
     * @return
     */
    List<ProdDetVo> prodDet(Long prodId);
    /**
     * 产品上下架
     * @return
     */
    void changeState(ProdStateForm params);
    /**
     * 产品设计列表
     * @return
     */
    PageInfo<ProdDesignVo> prodDesign(ProdDesignForm params);
    /**
     * 产品新增
     * @return
     */
    void prodAdd(ProdDetForm params);
    /**
     * 产品删除
     * @return
     */
    void prodDel(Long prodId);
    /**
     * 产品修改
     * @return
     */
    void prodEdit(ProdDetForm params);
    /**
     * 库表列表
     * @return
     */
    List<TblListVo> tblList(Long prodId);
    /**
     * 子系统获取项目名称
     * @return
     */
    String getProdName(Long prodId);
    /**
     * 菜单列表
     * @return
     */
    List<MenuListVo> menuList(Long prodId);
    /**
     * 菜单新增
     * @return
     */
    void menuAdd(Long prodId);
    /**
     * 菜单删除
     * @return
     */
    void menuDel(Long menuId);
    /**
     * 菜单修改
     * @return
     */
    void menuEdit(MenuEditForm params);
     /**
     * 菜单树
     * @return
     */
    List<MenuTreeVo> menuTree(Long prodId);
    /**
     * 根据菜单树查组件
     * @return
     */
    PageInfo<ToolListVo> toolSel(String params,ToolListForm params1);
     /**
     * 组件配置详细
     * @return
     */
     ToolConfVo toolConf(Long relatId);
    /**
     * 组件配置修改
     * @return
     */
    void relatEdit(RelatForm params);
    /**
     * 组件字典-基础表
     * @return
     */
    List<TblListVo> tblDict(Long relatId);
     /**
     * 组件展示-基础信息组件
     * @return
     */
    List<BasicCol> basicView(Long relatId);
    /**
     * 组件展示-流程组件
     * @return
     */
    List<FlowViewVo> flowView(Long relatId);
    /**
     * 规则配置列表
     * @return
     */
    List<RuleListVo> ruleList(Long relatId);
    /**
     * 规则配置字典
     * @return
     */
    RuleDictVo ruleDict(Long relatId);
//    /**
//     * 产品演示
//     * @return
//     */
//    List<ProdViewVo> prodView(String params);
//    /**
//     * 基础表保存
//     * @return
//     */
//    void tblSave(BasicTblList params);
//
//    /**
//     * 菜单保存
//     * @return
//     */
//    void menuSave(MenuListForm params);
////    /**
////     * 流程组件保存
////     * @return
////     */
////    void flowSave(FlowListForm params);
//    /**
//     * 基础库表列表
//     * @return
//     */
////    List<TblImpForm> tblList(String params);
////    List<TblImpForm> tblDet(String params);
//    void relatSave(RelatForm params);
//    /**
//     * 基础档案组件导入
//     * @return
//     */
//    void basicImp(MultipartFile file,Long tblId,String tblCode) throws Exception;
//    /**
//     * 自建表字段配置列表
//     * @return
//     */
////    List<BasicCol> basicCol(Long id);
////    /**
////     * 自建表字段配置保存
////     * @return
////     */
////    void colSave(BasicCol params);
////    /**
////     * 子系统查询条件和查询结果展示
////     * @return
////     */
////    List<ChildTblSelVo> childTblSel(String menuId);
////    /**
////     * 子系统主表查看
////     * @return
////     */
////    PageInfo<ChildTblForm> childTblCont(String menuId,ChildTblForm params);
////    /**
////     * 子系统详情页
////     * @return
////     */
////    ChildTblDetForm childTblDet(String params);
//    /**
//     * 子系统主表查看
//     * @return
//     */
//    List<MainTblVo> mainTbl(String params);
}
