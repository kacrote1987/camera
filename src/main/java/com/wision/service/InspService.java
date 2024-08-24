package com.wision.service;

import com.wision.entity.InspForm;
import com.wision.entity.InspVos;

import java.util.List;

public interface InspService {
    /**
     * 报告列表
     * @return
     */
    List<InspVos> inspList(InspForm params);
}
