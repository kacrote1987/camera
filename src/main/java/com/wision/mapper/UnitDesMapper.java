package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UnitDesMapper {
    List<UnitListVo> toolList(@Param("params") UnitListForm params);
}
