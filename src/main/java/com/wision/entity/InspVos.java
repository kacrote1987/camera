package com.wision.entity;

import java.util.List;

public class InspVos {
    private List<InspVo> inspListVo;
    private Long inspTotal;

    public List<InspVo> getInspListVo() {
        return inspListVo;
    }

    public void setInspListVo(List<InspVo> inspListVo) {
        this.inspListVo = inspListVo;
    }

    public Long getInspTotal() {
        return inspTotal;
    }

    public void setInspTotal(Long inspTotal) {
        this.inspTotal = inspTotal;
    }
}
