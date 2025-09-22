package com.camera.mapper;

import com.camera.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CameraMapper {
    List<ApplyList> applyList(@Param("params") ApplyList params);
    List<ApplyDet> applyDet(Long applyId);
    List<ApplyPoint> applyPoint(Long applyId);
    List<CameraList> cameraList(@Param("params") CameraList params);
    List<CameraDet> cameraDet(Long cameraId);
    boolean cameraSave(@Param("params") CameraDet params);
    List<LnglatDet> lngLat();
    List<CameraDet> lnglatDet(String cameraLng, String cameraLat);
    List<LnglatDet> lnglatDraw();
    List<AreaDraw> areaDraw();
    boolean insertArea(String params);
    List<PosDet> posDet(Long posId);
    List<TagList> tagList(@Param("params") TagList params);
    List<TagDetVo> tagDet(Long tagId);
    boolean insertTag(@Param("params") TagDetForm params);
    boolean deleteTag(Long posId);
    boolean updateTag(@Param("params") TagDetForm params);
    List<TagList> tagGather();
    boolean updatePre(@Param("params") CameraList params);
    List<TagDetVo> reqTag(Long posId);
    List<TagDetVo> reqOrder();
    List<TagDetVo> updateOrder1(String paraName);
    boolean updateOrder2(String paraName,String field,String value);
    boolean updateOrder3(String paraName,String field,String value);
    List<TagDetVo> reqList(List<String> list);
    List<ParamList> paramList(@Param("params") ParamList params);
    List<ParamList> paramDet(Long paramId);
    boolean updateParam(@Param("params") ParamList params);
//    List<TypeListVo> typeSeled(String posIds,String type);
//    List<TypeListVo> typeChksel(String posIds,Long camId);
    boolean typeSel(String posId,Long camId);
    List<RuleList> ruleList(@Param("params") RuleList params);
    List<RuleList> ruleDet(Long ruleId);
    boolean updateRule(@Param("params") RuleList params);
}
