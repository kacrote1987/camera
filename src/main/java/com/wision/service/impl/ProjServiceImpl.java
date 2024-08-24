package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.GanttDetForm;
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
        String projStepcode=params.getProjStepcode();
        if(projStepcode==null){
            projStepcode="step0"; }
        projStepcode=projStepcode.substring(4,projStepcode.length());
        List<ProjListForm> projList=projMapper.selProjList(projStepcode,params);
        return PageInfo.of(projList);
    }

    @Override
    public List<ProjDetForm> projDet(String projId) {
        List<ProjDetForm> projDet=projMapper.selProjDet(projId);
        return projDet;
    }

    @Override
    public void projSave(ProjDetForm params) {
        if(params.getAction().equals("add")){
            projMapper.insertProj(params);
        }else if(params.getAction().equals("del")){
            projMapper.deleteProj(params.getProjId());
        }else{
            projMapper.updateProj(params);
        }
    }

    @Override
    public void projStep(ProjListForm params) {
        projMapper.projStep(params.getProjId(),params.getStepVal());
    }

    @Override
    public PageInfo<ConseqList> conseqList(String params) {
        String projId=',' + params.substring(0,params.indexOf("=")) + ',';
        List<ConseqList> conseqList=projMapper.conseqList(projId);
        return PageInfo.of(conseqList);
    }

    @Override
    public List<ConseqDet> conseqDet(String conseqId) {
        List<ConseqDet> conseqDet=projMapper.selConseqDet(Long.valueOf(conseqId));
        return conseqDet;
    }

    @Override
    public void conseqSave(ConseqDet params) {
        System.out.println("action="+params.getAction()+";id="+params.getConseqId());
        if(params.getAction().equals("add")){
            params.setProjId(","+params.getProjId()+",");
            projMapper.insertConseq(params);
        }else if(params.getAction().equals("del")){
//            projMapper.deleteConseq(params.getConseqId());
            projMapper.updateConseqState(params.getConseqId());
        }else{
            projMapper.updateConseq(params);
        }
    }

    @Override
    public List<AssProj> assProj(String params) {
        Long projId=Long.valueOf(params.substring(0,params.indexOf("=")));
        String tbl=projMapper.getAssTbl(projId);
        List<AssProj> assProj=null;
        if(tbl.equals("t_ass_camera")){
            assProj = projMapper.assProj(projId);
        }
        return assProj;
    }

    @Override
    public List<ProjCostForm> projCost(String params) {
        Long projId=Long.valueOf(params.substring(0,params.indexOf("=")));
        String tbl=projMapper.getAssTbl(projId);
        List<ProjCostForm> projCost=null;
        if(tbl.equals("t_ass_camera")){
            projCost = projMapper.projCost(projId);
        }
        return projCost;
    }

    @Override
    public PageInfo<MeetListForm> meetList(MeetListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        List<MeetListForm> meetList=projMapper.meetList(params);
        return PageInfo.of(meetList);
    }

    @Override
    public List<MeetDetForm> meetDet(String projId) {
        return null;
    }

    @Override
    public void meetSave(MeetDetForm params) {

    }

    @Override
    public List<GanttDetForm> ganttDet(String params) {
        Long projId=Long.valueOf(params.substring(0,params.indexOf("=")));
        List<GanttDetForm> ganttdet=projMapper.selGanttDet(projId);
        return ganttdet;
    }

    @Override
    public void ganttDo(GanttDetForm params) {
        if(params.getValue()!="" && params.getValue()!=""){
            System.out.println("不为空");
        }else{
            System.out.println("为空");
        }
        if(params.getAction().equals("add")){
            projMapper.insertGantt(params.getProjId());
        }else if(params.getAction().equals("del")){
            projMapper.deleteGantt(params.getGanttId());
        }else{
            projMapper.updateGantt(params.getGanttId(),method(params.getField()),params.getValue());
        }
    }

    @Override
    public List<GanttDispForm> ganttDisp(Long projId) {
        List<GanttDispForm> ganttdisp=projMapper.selGanttDisp(projId);
        return ganttdisp;
    }

    @Override
    public void ganttLog(Long projId) {

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
