package com.wision.entity;

import java.util.List;

public class RuleDictVo {
    List<RuleDictExtVo> mainCode;
    List<RuleDictExtVo> selfCode;
    List<RuleDictExtVo> selfName;

    public List<RuleDictExtVo> getMainCode() {
        return mainCode;
    }

    public void setMainCode(List<RuleDictExtVo> mainCode) {
        this.mainCode = mainCode;
    }

    public List<RuleDictExtVo> getSelfCode() {
        return selfCode;
    }

    public void setSelfCode(List<RuleDictExtVo> selfCode) {
        this.selfCode = selfCode;
    }

    public List<RuleDictExtVo> getSelfName() {
        return selfName;
    }

    public void setSelfName(List<RuleDictExtVo> selfName) {
        this.selfName = selfName;
    }
}
