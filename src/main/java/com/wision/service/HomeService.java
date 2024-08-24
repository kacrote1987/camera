package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.DiaryForm;
import com.wision.entity.MenuListForm;
import com.wision.entity.*;

import java.util.List;

public interface HomeService {
    /**
     * 主页展示
     * @return
     */
    List<DocListVo> homeDisplay(String params);
    /**
     * 主页考核展示
     * @return
     */
    List<StatsListVo> statsDisply();
    /**
     * 个人日志详细
     * @return
     */
    List<LogVo> logDet(String params);
    /**
     * 个人日志保存
     * @return
     */
    void logSave(DiaryForm params);
    /**
     * 个人日志详细
     * @return
     */
    List<LogVo> logExport();
}
