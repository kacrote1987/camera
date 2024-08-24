package com.wision.service.impl;

import com.wision.entity.*;
import com.wision.mapper.CostMapper;
import com.wision.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CostServiceImpl implements CostService {
    @Resource
    CostMapper costMapper;

    @Override
    public List<CostVos> costList(CostForm params) {
        Long page=(Long.valueOf(params.getPage())-1)*10;
        List<CostVos> costList=costMapper.costTotal(params);
        costList.get(0).setCostVo(costMapper.selCost(page,params));
        return costList;
    }

    @Override
    public List<CostVos> costDet(String costId) {
        return null;
    }

    @Override
    public void costDo(CostForm params) {
        if(params.getAction().equals("add")){
            costMapper.insertCost(params);
        }else if(params.getAction().equals("del")){
            costMapper.deleteCost(params.getCostId());
        }else{
            costMapper.updateCost(params);
        }
    }

    @Override
    public List<CostMembVo> costMemb(String costId) {
        return null;
    }

    @Override
    public void costMembdo(CostMembForm params) {

    }

    @Override
    public List<InvoVos> invoList(InvoForm params) {
        Long page=(Long.valueOf(params.getPage())-1)*10;
        List<InvoVos> invoList=costMapper.invoTotal(params);
        invoList.get(0).setInvoVo(costMapper.selInvo(page,params));
        return invoList;
    }

    @Override
    public List<InvoDetVo> invoDet(String invoId) {
        List<InvoDetVo> InvoDet=null;
        if(!invoId.equals("add")){
            InvoDet=costMapper.selInvoDet(Long.valueOf(invoId));
        }
        return InvoDet;
    }

    @Override
    public void invoDo(InvoForm params) {
        if(params.getAction().equals("add")){
            costMapper.insertInvo(params);
        }else if(params.getAction().equals("del")){
            costMapper.deleteInvo(params.getInvoId());
        }else{
            costMapper.updateInvo(params);
        }
    }

    @Override
    public List<InvoMembVo> invoMemb(String params) {
        String invoId=params.substring(0,params.indexOf("="));
        List<InvoMembVo> membList=null;
        if(!invoId.equals("add")){
            membList=costMapper.selMemb(Long.valueOf(invoId));
        }
        return membList;
    }

    @Override
    public void invoMembdo(InvoMembForm params) {
        if(params.getAction().equals("add")){
            costMapper.insertMemb(params.getInvoId());
        }else if(params.getAction().equals("del")){
            costMapper.deleteMemb(params.getMembId());
        }else{
            costMapper.updateMemb(params.getMembId(),method(params.getField()),params.getValue());
        }
    }

    public static String method (String str){
        String pos1;
        String pos2=null;
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i); //把字符串转为字符
            if(c >= 'A' && c <= 'Z'){
                pos1=str.replace(c,(char)(c+32));
                pos2=pos1.substring(0,i)+'_'+pos1.substring(i,pos1.length());
            }
        }
        return pos2;
    }
}
