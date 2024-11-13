package com.wision.service;

import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

public interface UnitDesService {
    PageInfo<UnitListVo> toolList(UnitListForm params);
}
