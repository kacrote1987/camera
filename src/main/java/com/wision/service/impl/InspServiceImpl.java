package com.wision.service.impl;

import com.wision.entity.InspForm;
import com.wision.entity.InspVos;
import com.wision.mapper.InspMapper;
import com.wision.service.InspService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InspServiceImpl implements InspService {
    @Resource
    InspMapper inspMapper;

    @Override
    public List<InspVos> inspList(InspForm params) {
        Long page=(Long.valueOf(params.getPage())-1)*10;
        String inspStepCode=params.getInspStepCode();
        if(inspStepCode==null){
            inspStepCode="2";
        }else{
            inspStepCode=inspStepCode.substring(4,inspStepCode.length());
        }
        List<InspVos> inspList=inspMapper.inspTotal(inspStepCode,params);
        inspList.get(0).setInspListVo(inspMapper.selInspCond(page,inspStepCode,params));
        return inspList;
    }
}
