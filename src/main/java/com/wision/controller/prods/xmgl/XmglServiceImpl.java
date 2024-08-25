package com.wision.controller.prods.xmgl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XmglServiceImpl implements XmglService {

    @Override
    public List<XmglListVo> xmglList() {
        List<XmglListVo> xmglList = new ArrayList<>();
        xmglList.get(0).setCol1("1");
        return xmglList;
    }
}
