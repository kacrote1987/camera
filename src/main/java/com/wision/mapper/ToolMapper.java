package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ToolMapper {
    List<ToolListVo> toolList(@Param("params") ToolListForm params);
    List<ToolDetVo> toolDet(Long params);
    boolean insertTool(@Param("params") ToolDetForm params);
    boolean deleteTool(Long params);
    boolean updateTool(@Param("params") ToolDetForm params);
    String getRelatName(Long relatId);
    String getLayoutType(Long relatId);
    List<BasicSourTblVo> basicSourTbl(Long relatId);
    List<BasicCondVo> basicCond(Long relatId);
    List<BasicCol> getBasicCol(Long relatId);
//    List<RuleDictExtVo> getMainCode(Long relatId);
//    List<RuleDictExtVo> getSelfCode(Long relatId);
//    List<RuleDictExtVo> getSelfName(Long relatId);
//    boolean insertRule(@Param("params") RuleListForm params);
//    SourDetVo sourDet(Long relatId);
//    boolean layoutEdit(@Param("params") RelatForm params);
//    boolean sourEdit(@Param("params") RelatForm params);
//    List<FlowViewVo> flowView(Long relatId);
//    boolean insertFlow(Long relatId);
//    boolean deleteFlow(Long extId);
//    boolean updateFlow(Long extId,String field,String value);
}
