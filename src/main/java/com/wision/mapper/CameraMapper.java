package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CameraMapper {
    List<ApplyList> applyList(@Param("params") ApplyList params);
    List<CameraList> cameraList(@Param("params") CameraList params);
    List<CameraDet> cameraDet(Long cameraId);
    boolean cameraSave(@Param("params") CameraDet params);
    List<LnglatDetVo> lngLat();
    List<CameraDet> lnglatDet(String cameraLng, String cameraLat);
    List<LnglatDetVo> lnglatDraw();
    List<AreaDrawVo> areaDraw();
    boolean insertArea(String params);
    List<PosDetVo> posDet(Long posId);
    List<TagListVo> tagList(@Param("params") TagListForm params);
    List<TagDetVo> tagDet(Long tagId);
    boolean insertTag(@Param("params") TagDetForm params);
    boolean deleteTag(Long posId);
    boolean updateTag(@Param("params") TagDetForm params);
    List<TagListVo> tagGather();
    boolean updatePre(@Param("params") CameraList params);
    List<TagDetVo> reqTag(Long posId);
    List<TagDetVo> reqOrder();
    List<TagDetVo> updateOrder1(String paraName);
    boolean updateOrder2(String paraName,String field,String value);
    boolean updateOrder3(String paraName,String field,String value);
    List<TagDetVo> reqList(List<String> list);
    List<ParamListForm> paramList(ParamListForm params);
//    List<TypeListVo> typeSeled(String posIds,String type);
//    List<TypeListVo> typeChksel(String posIds,Long camId);
    boolean typeSel(String posId,Long camId);
    List<RuleListForm> ruleList(@Param("params") RuleListForm params);
}
