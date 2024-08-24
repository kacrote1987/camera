package com.wision.service.impl;

import com.wision.entity.DocListVo;
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
}
