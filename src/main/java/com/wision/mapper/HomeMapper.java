package com.wision.mapper;

import com.wision.entity.DocListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    List<DocListVo> homeDisplay(Long typeId);
}
