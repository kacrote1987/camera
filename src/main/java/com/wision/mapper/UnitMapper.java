package com.wision.mapper;

import com.wision.entity.UnitDetForm;
import com.wision.entity.UnitListForm;
import com.wision.entity.UnitDetVo;
import com.wision.entity.UnitListVo;
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
