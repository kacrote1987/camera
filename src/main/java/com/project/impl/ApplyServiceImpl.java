package com.project.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.entity.ApplyDetForm;
import com.project.entity.ApplyListForm;
import com.project.entity.ApplyStepForm;
import com.project.mapper.ApplyMapper;
import com.project.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Resource
    ApplyMapper applyMapper;

    @Override
    public PageInfo<ApplyListForm> applyList(ApplyListForm params) {
        PageHelper.startPage(params.getPage(), 10);
//        String projStepcode=params.getStep();
//        if(projStepcode==null){
//            projStepcode="step0"; }
//        projStepcode=projStepcode.substring(4,projStepcode.length());
        List<ApplyListForm> applyList=applyMapper.applyList(params);
        return PageInfo.of(applyList);
    }

    @Override
    public List<ApplyDetForm> applyDet(Long applyId) {
        List<ApplyDetForm> applyDet=applyMapper.applyDet(applyId);
        return applyDet;
    }

    @Override
    public void applyAdd(ApplyDetForm params) {
        applyMapper.insertApply(params);
    }

    @Override
    public void applyStep(ApplyStepForm params) {
        applyMapper.applyStep(params);
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
