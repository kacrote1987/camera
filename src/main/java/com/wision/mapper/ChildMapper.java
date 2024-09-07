package com.wision.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChildMapper {
    String getProdName(Long prodId);
}
