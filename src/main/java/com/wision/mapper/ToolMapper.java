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
    List<ToolListVo> toolSel(Long menuId,@Param("params") ToolListForm params);
}
