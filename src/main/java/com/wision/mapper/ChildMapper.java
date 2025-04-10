package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChildMapper {
    String getChildName(Long prodId);
    List<ChildMenuVo> getChildMenu(Long prodId);
    List<ChildTblCol> getTblSel(Long menuId, String res, String sel,Long projId);
    String getNickNameByMenuId(Long menuId);
    List<MainContVo> getMainCont(String tblName);
    String getBasicChildTbl(Long menuId);
    List<ChildTblForm> childTblCont(Long menuId, @Param("params1") ChildTblCont params1);
//    String getProdNikName(Long prodId);
//    String getToolPage(Long relatId);
//    String getRealPage(Long relatId);
}
