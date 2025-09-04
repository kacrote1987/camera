package com.project.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.entity.AssDet;
import com.project.entity.AssList;
import com.project.mapper.AssMapper;
import com.project.service.AssService;
import com.project.util.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AssServiceImpl implements AssService {
    @Resource
    AssMapper assMapper;

    @Override
    public PageInfo<AssList> assList(AssList params) {
        PageHelper.startPage(params.getPage(), 10);
        List<AssList> assList = assMapper.assList(params);
        return PageInfo.of(assList);
    }

    @Override
    public List<AssDet> assDet(String assId) {
        List<AssDet> assDet = null;
        if (!assId.equals("add")) {
            assDet = assMapper.selDet(Long.valueOf(assId));
        }
        return assDet;
    }

    @Override
    public void assSave(AssDet params) {
        if (params.getAction().equals("add")) {
            assMapper.insertAss(params);
        } else if (params.getAction().equals("del")) {
            assMapper.deleteAss(params.getAssId());
        } else {
            assMapper.updateAss(params);
        }
    }

    @Override
    public List<AssList> assType(String type) {
        List<AssList> assType = assMapper.assType(type);
        return assType;
    }

    @Override
    public void assImp(MultipartFile file) throws Exception {
        String[] keys = {"合同编号", "工程名称", "供应商", "制造商", "建设单位", "资产分类编码", "资产标签号", "资产名称", "规格型号", "单位", "数量"
        , "金额", "开始使用日期", "资产地点", "标清/高清", "状态", "备注"};
        List<Map<String, Object>> list = ExcelUtils.importExcel(file, keys);
        for (Map<String, Object> map : list) {
            assMapper.importAss(map.get("合同编号").toString(), map.get("工程名称").toString(), map.get("供应商").toString(), map.get("制造商").toString()
            , map.get("建设单位").toString(), map.get("资产分类编码").toString(), map.get("资产标签号").toString(), map.get("资产名称").toString()
            , map.get("规格型号").toString(), map.get("单位").toString(), map.get("数量").toString(), map.get("金额").toString(), map.get("开始使用日期").toString()
            , map.get("资产地点").toString(), map.get("标清/高清").toString(), map.get("状态").toString(), map.get("备注").toString());
        }
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
}
