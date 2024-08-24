package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.AssDet;
import com.wision.entity.NetListForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NetService {
    /**
     * 网络列表
     * @return
     */
    PageInfo<NetListForm> netList(NetListForm params);
    /**
     * 网络明细
     * @return
     */
    List<AssDet> netDet(String assId);
    /**
     * 网络保存
     * @return
     */
    void netSave(AssDet params);
    /**
     * 网络导入
     * @return
     */
    void netImp(MultipartFile file) throws Exception;
}
