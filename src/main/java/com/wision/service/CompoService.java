package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

public interface CompoService {
    PageInfo<CompoListVo> compoList(CompoListForm params);
//    List<UnitDetVo> toolDet(String params);
//    void toolSave(UnitDetForm params);
//    BasicSourVo basicSour(Long relatId);
//    List<BasicCondVo> basicCond(Long relatId);
//    void basicCondEdit(BasicCondForm1 params);
//    void basicCondAdd(BasicCondForm2 params);
//    List<BasicCol> basicView(Long relatId);
//    void basicCondDel(Long extId);
//    FlowCondMainVo flowCondMain(Long relatId);
//    void flowCondEdit(FlowCondForm params);
//    List<FlowViewVo> flowView(Long relatId);
//    void flowAdd(Long relatId);
//    void flowDel(Long extId);
//    void flowEdit(FlowListForm params);
//    /**
//     * 规则配置字典
//     * @return
//     */
//    RuleDictVo ruleDict(Long relatId);
//    /**
//     * 规则配置新增
//     * @return
//     */
//    void ruleAdd(RuleListForm params);
//    /**
//     * 组件数据源详细
//     * @return
//     */
//    SourDetVo sourDet(Long relatId);
//    /**
//     * 组件数据源修改
//     * @return
//     */
//    void layoutEdit(RelatForm params);
//    /**
//     * 组件数据源修改
//     * @return
//     */
//    void sourEdit(RelatForm params);
    //    void qrcode();
//    void payByWx();
//    void kafka();
}
