package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ChildMainVo;
import com.wision.entity.ChildTblForm;
import com.wision.entity.MainContVo;
import com.wision.entity.MainSelVo;

import java.util.List;

public interface ProdStoService {
    String getChildName(Long prodId);
    ChildMainVo getChildMain(Long prodId);
    List<MainSelVo> mainSel(Long menuId);
    PageInfo<MainContVo> mainCont(Long menuId, ChildTblForm params);
}
