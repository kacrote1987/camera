package com.wision.mapper;

import com.wision.entity.ChildMenuVo;
import com.wision.entity.ChildTblCol;
import com.wision.entity.MainContVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChildMapper {
    String getChildName(Long prodId);
    List<ChildMenuVo> getChildMenu(Long prodId);
    List<ChildTblCol> getTblSel(Long menuId, String res, String sel);
    String getToolPage(Long menuId);
    List<MainContVo> getMainCont(String tblName);
}
