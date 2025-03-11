package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChildMapper {
    String getChildName(Long prodId);
    List<ChildMenuVo> getChildMenu(Long prodId);
    List<ChildTblCol> getTblSel(Long menuId, String res, String sel);
    String getNickNameByMenuId(Long menuId);
    List<MainContVo> getMainCont(String tblName);
//    String getProdNikName(Long prodId);
//    String getToolPage(Long relatId);
//    String getRealPage(Long relatId);
}
