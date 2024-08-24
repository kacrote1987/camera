package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ToolDetForm;
import com.wision.entity.ToolDetVo;
import com.wision.entity.ToolListForm;
import com.wision.entity.ToolListVo;

import java.util.List;

public interface ToolService {
    /**
     * 组件列表
     * @return
     */
    PageInfo<ToolListVo> toolList(ToolListForm params);
    /**
     * 组件详细
     * @return
     */
    List<ToolDetVo> toolDet(String params);
    /**
     * 组件保存
     * @return
     */
    void toolSave(ToolDetForm params);
    /**
     * 组件查询
     * @return
     */
    PageInfo<ToolListVo> toolSel(String params,ToolListForm params1);
}
