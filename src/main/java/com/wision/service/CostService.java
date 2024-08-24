package com.wision.service;

import com.wision.entity.*;

import java.util.List;

public interface CostService {
    /**
     * 费用列表
     * @return
     */
    List<CostVos> costList(CostForm params);
    /**
     * 费用详细
     * @return
     */
    List<CostVos> costDet(String costId);
    /**
     * 费用增删改
     * @return
     */
    void costDo(CostForm params);
    /**
     * 费用明细
     * @return
     */
    List<CostMembVo> costMemb(String costId);
    /**
     * 费用明细增删改
     * @return
     */
    void costMembdo(CostMembForm params);
    /**
     * 发票列表
     * @return
     */
    List<InvoVos> invoList(InvoForm params);
    /**
     * 发票详细
     * @return
     */
    List<InvoDetVo> invoDet(String invoId);
    /**
     * 发票增删改
     * @return
     */
    void invoDo(InvoForm params);
    /**
     * 发票项目内容
     * @return
     */
    List<InvoMembVo> invoMemb(String params);
    /**
     * 发票明细增删改
     * @return
     */
    void invoMembdo(InvoMembForm params);
}
