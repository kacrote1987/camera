package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ApiDet;
import com.wision.entity.ApiList;
import com.wision.entity.InsureForm;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ApiService {
    /**
     * 接口列表
     * @return
     */
    PageInfo<ApiList> apiList(ApiList params);
    /**
     * 接口详细
     * @return
     */
    List<ApiDet> apiDet(String apiId);
    /**
     * 接口列表
     * @return
     */
    void apiSave(ApiDet params);
    /**
     * 导入Excel
     * @return
     */
    void excelImport(@RequestParam MultipartFile file, @RequestParam String table) throws Exception ;
    /**
     * 获取时间戳
     * @return
     */
    void getRequestTime(Long apiId);
    /**
     * 获取请求密钥
     * @return
     */
    void getSign2(ApiDet params);
    /**
     * 接口信息更新
     * @return
     */
    void insureRequest();
    /**
     * 人员社保信息列表
     * @return
     */
    List<InsureForm> insureList(InsureForm params);
}
