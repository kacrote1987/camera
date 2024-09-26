package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.List;

public interface ToolDesService {
    PageInfo<ToolListVo> toolList(ToolListForm params);
}
