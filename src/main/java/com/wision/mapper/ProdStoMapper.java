package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProdStoMapper {
    List<ProdListVo> prodList(@Param("params") ProdListForm params);
    List<ProdDetVo> prodDet(Long prodId);
    boolean offLine(Long prodId);
    String getChildName(Long prodId);
    List<ChildMenuVo> getChildMenu(Long prodId);
    List<ChildTblCol> getTblSel(Long menuId, String res, String sel);
    String getRealPage(Long menuId);
    List<MainContVo> getMainCont(String tblName);
}
