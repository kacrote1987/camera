package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RuleMapper {
    List<RuleListVo> ruleList(@Param("params") RuleListForm params);
    RuleDetVo ruleDet(Long prodId);
}
