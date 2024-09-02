package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.RuleDetVo;
import com.wision.entity.RuleListForm;
import com.wision.entity.RuleListVo;

public interface RuleService {
    /**
     * 规则列表
     * @return
     */
    PageInfo<RuleListVo> ruleList(RuleListForm params);
    /**
     * 规则详细
     * @return
     */
    RuleDetVo ruleDet(Long ruleId);
}
