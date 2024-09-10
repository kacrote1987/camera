package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ToolMapper;
import com.wision.service.ToolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {
    @Resource
    ToolMapper toolMapper;

    @Override
    public PageInfo<ToolListVo> toolList(ToolListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ToolListVo> toolList = toolMapper.toolList(params);
        return PageInfo.of(toolList);
    }

    @Override
    public List<ToolDetVo> toolDet(String params) {
        List<ToolDetVo> toolDet = null;
        if (!params.equals("add")) {
            toolDet = toolMapper.toolDet(Long.valueOf(params));
        }
        return toolDet;
    }

    @Override
    public void toolSave(ToolDetForm params) {
        if (params.getAction().equals("add")) {
            toolMapper.insertTool(params);
        } else if (params.getAction().equals("del")) {
            toolMapper.deleteTool(params.getToolId());
        } else {
            toolMapper.updateTool(params);
        }
    }

    @Override
    public BasicSourVo basicSour(Long relatId) {
        BasicSourVo basicSour = new BasicSourVo();
        basicSour.setRelatName(toolMapper.getRelatName(relatId));
        basicSour.setRelatName(toolMapper.getLayoutType(relatId));
        basicSour.setBasicSourTblVo(toolMapper.basicSourTbl(relatId));
        return basicSour;
    }

    @Override
    public List<BasicCondVo> basicCond(Long relatId) {
        List<BasicCondVo> basicCond=toolMapper.basicCond(relatId);
        return basicCond;
    }

    @Override
    public List<BasicCol> basicView(Long relatId) {
        List<BasicCol> basicView = toolMapper.getBasicCol(relatId);
        return basicView;
    }

    @Override
    public void basicCondAdd(Long params) {

    }

    @Override
    public List<BasicCol> basicCondDel(Long relatId) {
        return null;
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

//    @Override
//    public List<FlowViewVo> flowView(Long relatId) {
//        List<FlowViewVo> flowView=toolMapper.flowView(relatId);
//        return flowView;
//    }
//
//    @Override
//    public void flowAdd(Long relatId) {
//        toolMapper.insertFlow(relatId);
//    }
//
//    @Override
//    public void flowDel(Long extId) {
//        toolMapper.deleteFlow(extId);
//    }
//
//    @Override
//    public void flowEdit(FlowListForm params) {
//        toolMapper.updateFlow(params.getExtId(),method(params.getField()),params.getValue());
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
