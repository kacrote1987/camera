package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.ToolDetForm;
import com.wision.entity.ToolDetVo;
import com.wision.entity.ToolListForm;
import com.wision.entity.ToolListVo;
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
