package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ProdService {
    PageInfo<ProdListVo> storeList(ProdListForm params);
    PageInfo<ProdListVo> prodList(ProdListForm params);
    List<ProdDetVo> prodDet(Long prodId);
    void prodEdit(ProdDetForm params);
    void prodAdd(ProdDetForm params);
    void prodDel(Long prodId);
    void onLine(Long prodId);
    void offLine(Long prodId);
    List<TblListVo> tblList(Long prodId);
    List<MenuListVo> menuList(Long prodId);
    void menuAdd(Long prodId);
    void menuDel(Long menuId);
    void menuEdit(MenuEditForm params);
    List<MenuTreeVo> menuTree(Long prodId);
    PageInfo<CompoSelVo> compoSel(String params, CompoListForm params1);
//    List<ChildListVo> childList(Long menuId);
//    void createPage(Long menuId);
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
