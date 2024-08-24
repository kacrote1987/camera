package com.wision.mapper;

import com.wision.entity.DiaryForm;
import com.wision.entity.LogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopMapper {
    List<LogVo> selDiary(@Param("params") DiaryForm params);
    boolean insertDiary(@Param("params") DiaryForm params);
    boolean updateDiary(@Param("params") DiaryForm params);
    boolean deleteDiary();
}
