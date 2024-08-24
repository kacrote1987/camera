package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.DiaryForm;
import com.wision.entity.MenuListForm;
import com.wision.entity.*;
import com.wision.mapper.HomeMapper;
import com.wision.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    HomeMapper homeMapper;

    @Override
    public List<DocListVo> homeDisplay(String params) {
        Long typeId=Long.valueOf(params.substring(0,params.indexOf("=")));
        List<DocListVo> homeDisplay=homeMapper.homeDisplay(typeId);
        return homeDisplay;
    }

    @Override
    public List<StatsListVo> statsDisply() {
        List<StatsListVo> statsDisply=null;
//        List<StatsListVo> statsDisply=homeMapper.statsDisply();
        return statsDisply;
    }

    @Override
    public List<LogVo> logDet(String params) {
        List<LogVo> logDet=homeMapper.logDet(params);
        LogVo diaryVo=new LogVo();
        if(logDet.size()==0){
            diaryVo.setDiaryNote("");
            logDet.add(diaryVo);
        }
        return logDet;
    }

    @Override
    public void logSave(DiaryForm params) {
        List<LogVo> logDet=homeMapper.logDet(params.getLogName());
        if(logDet.size()==0){
            homeMapper.insertLog(params);
        }else{
            homeMapper.updateLog(params);
        }
    }

    @Override
    public List<LogVo> logExport() {
        List<LogVo> logExport=homeMapper.logExport();
        return logExport;
    }
}
