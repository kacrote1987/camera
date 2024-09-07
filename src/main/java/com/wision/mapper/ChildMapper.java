package com.wision.mapper;

import com.wision.entity.ChildMenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChildMapper {
    String getChildName(Long prodId);
    List<ChildMenuVo> getChildMenu(Long prodId);
}
