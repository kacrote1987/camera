package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ToolDesMapper {
    List<ToolListVo> toolList(@Param("params") ToolListForm params);
    List<ToolDetVo> toolDet(Long params);
    boolean insertTool(@Param("params") ToolDetForm params);
    boolean deleteTool(Long params);
    boolean updateTool(@Param("params") ToolDetForm params);
    String getRelatName(Long relatId);
    String getLayoutType(Long relatId);
    List<BasicSourTblVo> basicSourTbl(Long relatId);
    List<BasicCondVo> basicCond(Long relatId);
    boolean updateBasicCond(@Param("params") BasicCondForm1 params);
    String getBasicCodeByName(Long relatId,String keyName);
    boolean insertBasicCond(@Param("params") BasicCondForm2 params, String toolCode);
    List<BasicCol> getBasicCol(Long relatId);
    boolean deleteBasicCond(Long ruleId);
    FlowCondVo flowCond(Long relatId);
    boolean updateFlowCond(@Param("params") FlowCondForm params);
    List<FlowViewVo> flowView(Long relatId);
    boolean insertFlow(Long relatId);
    boolean deleteFlow(Long extId);
    boolean updateFlow(Long extId,String field,String value);
//    List<RuleDictExtVo> getMainCode(Long relatId);
//    List<RuleDictExtVo> getSelfCode(Long relatId);
//    List<RuleDictExtVo> getSelfName(Long relatId);
//    SourDetVo sourDet(Long relatId);
//    boolean layoutEdit(@Param("params") RelatForm params);
//    boolean sourEdit(@Param("params") RelatForm params);
}
