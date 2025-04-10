package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ChildService {
    String getChildName(Long prodId);
    ChildMainVo getChildMain(Long prodId);
    List<MainSelVo> mainSel(Long menuId);
    PageInfo<MainContVo> mainCont(Long menuId, ChildTblForm params);
    ChildTblDetForm childTblDet(String params);
    List<ChildTblSelVo> childTblSel(String menuId);
    PageInfo<ChildTblForm> childTblCont(String menuId,ChildTblForm params);
//    void generate(Long prodId);
}
