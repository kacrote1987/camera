package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ChildMainVo;
import com.wision.entity.TblContVo;

public interface ChildService {
    /**
     * 获取子系统项目名称
     * @return
     */
    String getChildName(Long prodId);
    /**
     * 获取子系统菜单
     * @return
     */
    ChildMainVo getChildMain(Long prodId);
    /**
     * 获取子系统主表
     * @return
     */
    PageInfo<TblContVo> tblCont(Long menuId);
}
