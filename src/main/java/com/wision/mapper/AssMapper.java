package com.wision.mapper;

import com.wision.entity.AssDet;
import com.wision.entity.AssList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssMapper {
    List<AssList> assList(@Param("params") AssList params);
    List<AssDet> selDet(Long assId);
    boolean insertAss(@Param("params") AssDet params);
    boolean deleteAss(Long assId);
    boolean updateAss(@Param("params") AssDet params);
    List<AssList> assType(String type);
    boolean importAss(String htbh,String gcmc,String gys,String zzs,String jsdw,String zcflbm,String zcbqh,String zcmc,String ggxh
    ,String dw,String sl,String je,String kssyrq,String zcdd,String bq,String zt,String bz);
}
