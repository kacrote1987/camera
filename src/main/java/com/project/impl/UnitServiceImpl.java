package com.project.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.entity.UnitDetForm;
import com.project.entity.UnitListForm;
import com.project.entity.UnitDetVo;
import com.project.entity.UnitListVo;
import com.project.mapper.UnitMapper;
import com.project.service.UnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Resource
    UnitMapper unitMapper;

    @Override
    public PageInfo<UnitListVo> unitList(UnitListForm params,String type) {
        PageHelper.startPage(params.getPage(), 10);
        type=type.substring(0,type.indexOf("="));
        String unitType;
        if(type.equals("ywdw")){
            unitType="业务单位";
        } else if(type.equals("jldw")){
            unitType="监理单位";
        } else if(type.equals("sgdw")){
            unitType="施工单位";
        } else {
            unitType=params.getUnitType();
        }
        List<UnitListVo> unitList=unitMapper.selUnitList(params,unitType);
        return PageInfo.of(unitList);
    }

    @Override
    public List<UnitDetVo> unitDet(String unitId) {
        List<UnitDetVo> unitDet=unitMapper.selUnitDet(unitId);
        return unitDet;
    }

    @Override
    public void unitSave(UnitDetForm params) {
        if(params.getAction().equals("add")){
            unitMapper.insertUnit(params);
        }else if(params.getAction().equals("del")){
            unitMapper.deleteUnit(params.getUnitId());
        }else{
            unitMapper.updateUnit(params);
        }
    }

    @Override
    public List<UnitListVo> toWord(String url) {
        return null;
    }
}
