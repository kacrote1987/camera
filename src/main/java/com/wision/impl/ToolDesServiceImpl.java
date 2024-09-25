package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ToolDesMapper;
import com.wision.service.ToolDesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ToolDesServiceImpl implements ToolDesService {
    @Resource
    ToolDesMapper toolDesMapper;

    @Override
    public PageInfo<ToolListVo> toolList(ToolListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ToolListVo> toolList = toolDesMapper.toolList(params);
        return PageInfo.of(toolList);
    }

    @Override
    public List<ToolDetVo> toolDet(String params) {
        List<ToolDetVo> toolDet = null;
        if (!params.equals("add")) {
            toolDet = toolDesMapper.toolDet(Long.valueOf(params));
        }
        return toolDet;
    }

    @Override
    public void toolSave(ToolDetForm params) {
        if (params.getAction().equals("add")) {
            toolDesMapper.insertTool(params);
        } else if (params.getAction().equals("del")) {
            toolDesMapper.deleteTool(params.getToolId());
        } else {
            toolDesMapper.updateTool(params);
        }
    }

    @Override
    public BasicSourVo basicSour(Long relatId) {
        BasicSourVo basicSour = new BasicSourVo();
        basicSour.setRelatName(toolDesMapper.getRelatName(relatId));
        basicSour.setLayoutType(toolDesMapper.getLayoutType(relatId));
        basicSour.setBasicSourTblVo(toolDesMapper.basicSourTbl(relatId));
        return basicSour;
    }

    @Override
    public List<BasicCondVo> basicCond(Long relatId) {
        List<BasicCondVo> basicCond=toolDesMapper.basicCond(relatId);
        return basicCond;
    }

    @Override
    public void basicCondEdit(BasicCondForm1 params) {
        toolDesMapper.updateBasicCond(params);
    }

    @Override
    public void basicCondAdd(BasicCondForm2 params) {
        String toolCode = toolDesMapper.getBasicCodeByName(params.getRelatId(),params.getKeyName());
        toolDesMapper.insertBasicCond(params,toolCode);
    }

    @Override
    public List<BasicCol> basicView(Long relatId) {
        List<BasicCol> basicView = toolDesMapper.getBasicCol(relatId);
        return basicView;
    }

    @Override
    public void basicCondDel(Long ruleId) {
        toolDesMapper.deleteBasicCond(ruleId);
    }

    @Override
    public FlowCondVo flowCond(Long relatId) {
        FlowCondVo flowCond = toolDesMapper.flowCond(relatId);
        return flowCond;
    }

    @Override
    public void flowCondEdit(FlowCondForm params) {
        toolDesMapper.updateFlowCond(params);
    }

    @Override
    public List<FlowViewVo> flowView(Long relatId) {
        List<FlowViewVo> flowView=toolDesMapper.flowView(relatId);
        return flowView;
    }

    @Override
    public void flowAdd(Long relatId) {
        toolDesMapper.insertFlow(relatId);
    }

    @Override
    public void flowDel(Long extId) {
        toolDesMapper.deleteFlow(extId);
    }

    @Override
    public void flowEdit(FlowListForm params) {
        toolDesMapper.updateFlow(params.getExtId(),method(params.getField()),params.getValue());
    }

//    @Override
//    public RuleDictVo ruleDict(Long relatId) {
//        RuleDictVo ruleDict = new RuleDictVo();
//        List<RuleDictExtVo> mainCode = toolMapper.getMainCode(relatId);
////        List<RuleDictExtVo> selfCode = toolMapper.getSelfCode(relatId);
////        List<RuleDictExtVo> selfName = toolMapper.getSelfName(relatId);
//        ruleDict.setMainCode(mainCode);
////        ruleDict.get(0).setSelfCode(selfCode);
////        ruleDict.get(0).setSelfName(selfName);
//        return ruleDict;
//    }
//
//    @Override
//    public void ruleAdd(RuleListForm params) {
//        toolMapper.insertRule(params);
//    }
//
//    @Override
//    public SourDetVo sourDet(Long relatId) {
//        SourDetVo sourDet=toolMapper.sourDet(relatId);
//        return sourDet;
//    }
//
//    @Override
//    public void layoutEdit(RelatForm params) {
//        toolMapper.layoutEdit(params);
//    }
//
//    @Override
//    public void sourEdit(RelatForm params) {
//        toolMapper.sourEdit(params);
//    }

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
