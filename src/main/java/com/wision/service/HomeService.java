package com.wision.service;

import com.wision.entity.DocListVo;

import java.util.List;

public interface HomeService {
    /**
     * 主页展示
     * @return
     */
    List<DocListVo> homeDisplay(String params);
}
