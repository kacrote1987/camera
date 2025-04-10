package com.wision.entity;

import java.util.List;

public class StatsListVos {
    private List<StatsListVo> statsListVo;
    private Long statsTotal;

    public List<StatsListVo> getStatsListVo() {
        return statsListVo;
    }

    public void setStatsListVo(List<StatsListVo> statsListVo) {
        this.statsListVo = statsListVo;
    }

    public Long getStatsTotal() {
        return statsTotal;
    }

    public void setStatsTotal(Long statsTotal) {
        this.statsTotal = statsTotal;
    }
}
