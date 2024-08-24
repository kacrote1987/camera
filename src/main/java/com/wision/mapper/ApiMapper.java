package com.wision.mapper;

import com.wision.entity.ApiDet;
import com.wision.entity.ApiList;
import com.wision.entity.InsureForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiMapper {
    List<ApiList> apiList(@Param("params") ApiList params);
    List<ApiDet> apiDet(Long apiId);
    boolean insertApi(@Param("params") ApiDet params);
    boolean deleteApi(Long apiId);
    boolean updateApi(@Param("params") ApiDet params);
    boolean insertExcel(String table,String dept,String name,String score,String dwsl,String bgsh,String jsl,String hgl);
    boolean updateRequestTime(String requestTime,Long apiId);
    List<InsureForm> selectInsure(@Param("params") InsureForm params);
    List<InsureForm> selectInsureAll();
    boolean updateInsure(String idCard,String cbChk,String jyChk);
}
