package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.SourListForm;
import com.wision.entity.SourListVo;

public interface DataService {
    /**
     * 数据源列表
     * @return
     */
    PageInfo<SourListVo> sourList(SourListForm params);
    /**
     * 数据源明细
     * @return
     */
//    List<AssDetVo> assDet(String assId);
    /**
     * 数据源保存
     * @return
     */
//    void assSave(AssDetForm params);
    /**
     * 发送请求
     * @return
     */
    void send();
}
