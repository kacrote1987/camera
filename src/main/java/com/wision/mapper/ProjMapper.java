package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjMapper {
    List<ProjListForm> selProjList(@Param("params") ProjListForm params);
}
