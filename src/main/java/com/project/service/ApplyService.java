package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.entity.ApplyDetForm;
import com.project.entity.ApplyListForm;
import com.project.entity.ApplyStepForm;

import java.util.List;

public interface ApplyService {
    /**
     * 申请单列表
     * @return
     */
    PageInfo<ApplyListForm> applyList(ApplyListForm params);
    /**
     * 申请单详情
     * @return
     */
    List<ApplyDetForm> applyDet(Long applyId);
    /**
     * 申请单新增
     * @return
     */
    void applyAdd(ApplyDetForm params);
    /**
     * 申请单流转
     * @return
     */
    void applyStep(ApplyStepForm params);
}
