package com.wision.mapper;

import com.wision.entity.CostForm;
import com.wision.entity.InvoForm;
import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CostMapper {
    List<CostVos> costTotal(@Param("params") CostForm params);
    List<CostVo> selCost(Long page,@Param("params") CostForm params);
    boolean insertCost(@Param("params") CostForm params);
    boolean deleteCost(Long costId);
    boolean updateCost(@Param("params") CostForm params);
    List<InvoVos> invoTotal(@Param("params") InvoForm params);
    List<InvoVo> selInvo(Long page,@Param("params") InvoForm params);
    List<InvoDetVo> selInvoDet(Long invoId);
    boolean insertInvo(@Param("params") InvoForm params);
    boolean deleteInvo(Long invoId);
    boolean updateInvo(@Param("params") InvoForm params);
    List<InvoMembVo> selMemb(Long invoId);
    boolean insertMemb(Long invoId);
    boolean deleteMemb(Long membId);
    boolean updateMemb(Long membId,String field,String value);
}
