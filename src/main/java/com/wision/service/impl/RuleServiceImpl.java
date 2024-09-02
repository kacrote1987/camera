package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.RuleMapper;
import com.wision.service.RuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Resource
    RuleMapper ruleMapper;

    @Override
    public PageInfo<RuleListVo> ruleList(RuleListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<RuleListVo> ruleList = ruleMapper.ruleList(params);
        return PageInfo.of(ruleList);
    }

    @Override
    public RuleDetVo ruleDet(Long ruleId) {
        RuleDetVo ruleDet=ruleMapper.ruleDet(ruleId);
        return ruleDet;
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
