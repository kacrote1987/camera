package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ProjService {
    /**
     * 项目列表
     * @return
     */
    PageInfo<ProjListForm> projList(ProjListForm params);
}
