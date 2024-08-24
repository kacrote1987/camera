package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.AssDet;
import com.wision.entity.NetListForm;
import com.wision.mapper.AssMapper;
import com.wision.mapper.NetMapper;
import com.wision.service.NetService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NetServiceImpl implements NetService {
    @Resource
    NetMapper netMapper;
    AssMapper assMapper;

    @Override
    public PageInfo<NetListForm> netList(NetListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        List<NetListForm> netList = netMapper.netList(params);
        return PageInfo.of(netList);
    }

    @Override
    public List<AssDet> netDet(String assId) {
        List<AssDet> netDet = null;
        if (!assId.equals("add")) {
            netDet = netMapper.selDet(Long.valueOf(assId));
        }
        return netDet;
    }

    @Override
    public void netSave(AssDet params) {
        if (params.getAction().equals("add")) {
            netMapper.insertAss(params);
        } else if (params.getAction().equals("del")) {
            netMapper.deleteAss(params.getAssId());
        } else {
            netMapper.updateAss(params);
        }
    }

    @Override
    public void netImp(MultipartFile file) throws Exception {

    }

//    @Override
//    public void assImp(MultipartFile file) throws Exception {
//        String[] keys = {"合同编号", "工程名称", "供应商", "制造商", "建设单位", "资产分类编码", "资产标签号", "资产名称", "规格型号", "单位", "数量"
//        , "金额", "开始使用日期", "资产地点", "标清/高清", "状态", "备注"};
//        List<Map<String, Object>> list = ExcelUtils.importExcel(file, keys);
//        for (Map<String, Object> map : list) {
//            assMapper.importAss(map.get("合同编号").toString(), map.get("工程名称").toString(), map.get("供应商").toString(), map.get("制造商").toString()
//            , map.get("建设单位").toString(), map.get("资产分类编码").toString(), map.get("资产标签号").toString(), map.get("资产名称").toString()
//            , map.get("规格型号").toString(), map.get("单位").toString(), map.get("数量").toString(), map.get("金额").toString(), map.get("开始使用日期").toString()
//            , map.get("资产地点").toString(), map.get("标清/高清").toString(), map.get("状态").toString(), map.get("备注").toString());
//        }
//        以下为上传文件代码，导入Excel时不需要此步。
//        String fileName = file.getOriginalFilename();
//        String filePath = "D:/upload/";
//        File dest = new File(filePath + fileName);
//        try {
//            file.transferTo(dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
}
