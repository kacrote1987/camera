package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ProdStoService {
    PageInfo<ProdListVo> prodList(ProdListForm params);
    List<ProdDetVo> prodDet(Long prodId);
    void offLine(Long prodId);
    String getChildName(Long prodId);
    ChildMainVo getChildMain(Long prodId);
    List<MainSelVo> mainSel(Long menuId);
    PageInfo<MainContVo> mainCont(Long menuId, ChildTblForm params);
    void generate(Long prodId);
}
