package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.entity.UnitDetForm;
import com.project.entity.UnitListForm;
import com.project.entity.UnitDetVo;
import com.project.entity.UnitListVo;

import java.util.List;

public interface UnitService {
    /**
     * 单位列表
     * @return
     */
    PageInfo<UnitListVo> unitList(UnitListForm params,String type);
    /**
     * 单位详细
     * @return
     */
    List<UnitDetVo> unitDet(String unitId);
    /**
     * 单位保存
     * @return
     */
    void unitSave(UnitDetForm params);
    /**
     * 导出word
     * @return
     */
    List<UnitListVo> toWord(String url);
}
