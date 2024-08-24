package com.wision.mapper;

import com.wision.entity.DiaryForm;
import com.wision.entity.MenuListForm;
import com.wision.entity.LogVo;
import com.wision.entity.DocListVo;
import com.wision.entity.MenuListVo;
import com.wision.entity.StatsListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeMapper {
    List<DocListVo> homeDisplay(Long typeId);
    List<StatsListVo> statsDisply();
    List<LogVo> logDet(String params);
    boolean logSave(@Param("params") DiaryForm params);
    boolean insertLog(@Param("params") DiaryForm params);
    boolean updateLog(@Param("params") DiaryForm params);
    List<LogVo> logExport();
    List<MenuListVo> childList(@Param("params") MenuListForm params);
    List<MenuListVo> menuList(@Param("params") MenuListForm params);
}
