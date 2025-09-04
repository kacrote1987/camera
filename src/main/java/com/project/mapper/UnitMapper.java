package com.project.mapper;

import com.project.entity.UnitDetForm;
import com.project.entity.UnitListForm;
import com.project.entity.UnitDetVo;
import com.project.entity.UnitListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UnitMapper {
    List<UnitListVo> selUnitList(@Param("params") UnitListForm params,String unitType);
    List<UnitDetVo> selUnitDet(String unitId);
    boolean insertUnit(@Param("params") UnitDetForm params);
    boolean deleteUnit(Long unitId);
    boolean updateUnit(@Param("params") UnitDetForm params);
}
