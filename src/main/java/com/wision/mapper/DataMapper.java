package com.wision.mapper;

import com.wision.entity.SourListForm;
import com.wision.entity.SourListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataMapper {
    List<SourListVo> sourList(@Param("params") SourListForm params);
//    List<SourDetVo> sourDet(Long assId);
//    boolean insertAss(@Param("params") AssDetForm params);
//    boolean deleteAss(Long assId);
//    boolean updateAss(@Param("params") AssDetForm params);
}
