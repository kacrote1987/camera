package com.project.mapper;

import com.project.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyMapper {
    List<ApplyListForm> applyList(@Param("params") ApplyListForm params);
    List<ApplyDetForm> applyDet(Long applyId);
    boolean insertApply(@Param("params") ApplyDetForm params);
    boolean applyStep(@Param("params") ApplyStepForm params);
}
