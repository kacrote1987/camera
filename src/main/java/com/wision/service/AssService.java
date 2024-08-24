package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.AssDet;
import com.wision.entity.AssList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AssService {
    /**
     * 资产列表
     * @return
     */
    PageInfo<AssList> assList(AssList params);
    /**
     * 资产明细
     * @return
     */
    List<AssDet> assDet(String assId);
    /**
     * 资产增删改
     * @return
     */
    void assSave(AssDet params);
    /**
     * 资产类别
     * @return
     */
    List<AssList> assType(String type);
    /**
     * 资产导入
     * @return
     */
    void assImp(MultipartFile file) throws Exception;
}
