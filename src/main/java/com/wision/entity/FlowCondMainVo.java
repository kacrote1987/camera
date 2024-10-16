package com.wision.entity;

import java.util.List;

public class FlowCondMainVo {
    private FlowCondVo flowCondVo;
    private List<SourTblVo> mainColVo;
    private List<SourTblVo> relatColVo;

    public FlowCondVo getFlowCondVo() {
        return flowCondVo;
    }

    public void setFlowCondVo(FlowCondVo flowCondVo) {
        this.flowCondVo = flowCondVo;
    }

    public List<SourTblVo> getMainColVo() {
        return mainColVo;
    }

    public void setMainColVo(List<SourTblVo> mainColVo) {
        this.mainColVo = mainColVo;
    }

    public List<SourTblVo> getRelatColVo() {
        return relatColVo;
    }

    public void setRelatColVo(List<SourTblVo> relatColVo) {
        this.relatColVo = relatColVo;
    }
}
