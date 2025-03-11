package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.ProjDetForm;
import com.wision.entity.ProjListForm;
import com.wision.entity.*;
import com.wision.mapper.ProjMapper;
import com.wision.service.ProjService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjServiceImpl implements ProjService {
    @Resource
    ProjMapper projMapper;

    @Override
    public PageInfo<ProjListForm> projList(ProjListForm params) {
        PageHelper.startPage(params.getPage(), 10);
//        String projStepcode=params.getStep();
//        if(projStepcode==null){
//            projStepcode="step0"; }
//        projStepcode=projStepcode.substring(4,projStepcode.length());
        List<ProjListForm> projList=projMapper.selProjList(params);
        return PageInfo.of(projList);
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
