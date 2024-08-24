package com.wision.mapper;

import com.wision.entity.DocListForm;
import com.wision.entity.DocListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DocMapper {
    List<DocListVo> docList(String type1,Long type2,@Param("params") DocListForm params);
    List<DocListVo> docListHome(@Param("params") DocListForm params);
}
