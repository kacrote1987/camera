package com.project.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.entity.DocListForm;
import com.project.entity.*;
import com.project.mapper.DocMapper;
import com.project.service.DocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Resource
    DocMapper docMapper;

    @Override
    public PageInfo<DocListVo> docList(DocListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        String typeId=params.getTypeId();
        String type1;
        Long type2;
        if(typeId==null || typeId==""){
            type1="alll";
            type2=Long.valueOf("0");
        }else{
            type1=typeId.substring(0,4);
            type2=Long.valueOf(typeId.substring(4,typeId.length()));
        }
        List<DocListVo> docList=docMapper.docList(type1,type2,params);
        return PageInfo.of(docList);
    }

    @Override
    public List<DocDetVo> docDet(DocListForm params) {
        return null;
    }

    @Override
    public List<DocListVo> docListHome(DocListForm params) {
        List<DocListVo> docListHome=docMapper.docListHome(params);
        return docListHome;
    }
}
