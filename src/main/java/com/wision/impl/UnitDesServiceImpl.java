package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.UnitDesMapper;
import com.wision.service.UnitDesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UnitDesServiceImpl implements UnitDesService {
    @Resource
    UnitDesMapper toolDesMapper;

    @Override
    public PageInfo<UnitListVo> toolList(UnitListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<UnitListVo> toolList = toolDesMapper.toolList(params);
        return PageInfo.of(toolList);
    }

    public static String method (String str){
        String pos="";
        if(str!=null && str!=""){
            for (int i = 0; i < str.length(); i++) {
                char c=str.charAt(i); //把字符串转为字符
                if(c >= 'A' && c <= 'Z'){
                    pos=pos+'_'+(char)(c+32);
                }
                else{
                    pos=pos+c;
                }
            }
        }else{
            pos="";
        }
        return pos;
    }
}
