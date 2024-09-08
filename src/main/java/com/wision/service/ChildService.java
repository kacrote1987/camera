package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ChildMainVo;
import com.wision.entity.ChildTblForm;
import com.wision.entity.MainContVo;
import com.wision.entity.MainSelVo;

import java.util.List;

public interface ChildService {
    /**
     * 获取子系统项目名称
     * @return
     */
    String getChildName(Long prodId);
    /**
     * 获取子系统主要菜单
     * @return
     */
    ChildMainVo getChildMain(Long prodId);
    /**
     * 子系统查询条件和查询结果展示
     * @return
     */
    List<MainSelVo> mainSel(Long menuId);
    /**
     * 子系统主表查看
     * @return
     */
    PageInfo<MainContVo> mainCont(Long menuId, ChildTblForm params);
}
