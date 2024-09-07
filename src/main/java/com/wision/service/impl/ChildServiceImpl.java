package com.wision.service.impl;

import com.wision.mapper.ChildMapper;
import com.wision.service.ChildService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChildServiceImpl implements ChildService {
    @Resource
    ChildMapper childMapper;

    @Override
    public String getProdName(Long prodId) {
        String prodName = childMapper.getProdName(prodId);
        return prodName;
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
