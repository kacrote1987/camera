package com.wision.entity;

import java.util.List;

public class CostVos {
    private List<CostVo> costVo;
    private Long costTotal;

    public List<CostVo> getCostVo() {
        return costVo;
    }

    public void setCostVo(List<CostVo> costVo) {
        this.costVo = costVo;
    }

    public Long getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(Long costTotal) {
        this.costTotal = costTotal;
    }
}
