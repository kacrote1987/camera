package com.wision.mapper;

import com.wision.entity.AssDet;
import com.wision.entity.NetListForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NetMapper {
    List<NetListForm> netList(@Param("params") NetListForm params);
    List<AssDet> selDet(Long assId);
    boolean insertAss(@Param("params") AssDet params);
    boolean deleteAss(Long assId);
    boolean updateAss(@Param("params") AssDet params);
    boolean importAss(String htbh,String gcmc,String gys,String zzs,String jsdw,String zcflbm,String zcbqh,String zcmc,String ggxh
    ,String dw,String sl,String je,String kssyrq,String zcdd,String bq,String zt,String bz);
}
