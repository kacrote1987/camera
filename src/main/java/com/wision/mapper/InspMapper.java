package com.wision.mapper;

import com.wision.entity.InspForm;
import com.wision.entity.InspVo;
import com.wision.entity.InspVos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InspMapper {
    List<InspVos> inspTotal(String inspStepCode,@Param("params") InspForm params);
    List<InspVo> selInspCond(Long page,String inspStepCode,@Param("params") InspForm params);
}
