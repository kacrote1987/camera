package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ToolService {
    /**
     * 组件列表
     * @return
     */
    PageInfo<ToolListVo> toolList(ToolListForm params);
    /**
     * 组件详细
     * @return
     */
    List<ToolDetVo> toolDet(String params);
    /**
     * 组件保存
     * @return
     */
    void toolSave(ToolDetForm params);
    /**
     * 基础信息组件-组件配置-数据源字典
     * @return
     */
    BasicSourVo basicSour(Long relatId);
    /**
     * 基础信息组件-条件设置列表
     * @return
     */
    List<BasicCondVo> basicCond(Long relatId);
    /**
     * 基础信息组件-条件设置字典+组件展示
     * @return
     */
    List<BasicCol> basicView(Long relatId);
    /**
     * 基础信息组件-条件设置新增
     * @return
     */
    void basicCondAdd(Long params);
    /**
     * 基础信息组件-条件设置删除
     * @return
     */
    List<BasicCol> basicCondDel(Long relatId);
    /**
     * 组件展示-流程组件
     * @return
     */
    List<FlowViewVo> flowView(Long relatId);
    /**
     * 流程组件-流程项新增
     * @return
     */
    void flowAdd(Long relatId);
    /**
     * 流程组件-流程项删除
     * @return
     */
    void flowDel(Long extId);
    /**
     * 流程组件-流程项修改
     * @return
     */
    void flowEdit(FlowListForm params);
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
}
