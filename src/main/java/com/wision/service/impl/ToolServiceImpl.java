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
        PageHelper.startPage(params.getPage(), 10);
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
    public PageInfo<ToolListVo> toolSel(String prodId,ToolListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        String menuId;
        List<ToolListVo> toolSel = null;
        if(prodId.indexOf("menuId")>-1){
            menuId = prodId.substring(prodId.indexOf("menuId=")+7,prodId.length());
            toolSel = toolMapper.toolSel(Long.valueOf(menuId),params);
        }
        return PageInfo.of(toolSel);
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
