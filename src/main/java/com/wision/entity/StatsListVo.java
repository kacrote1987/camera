package com.wision.entity;

public class StatsListVo {
    private Long rowNum;
    private Long statsId;
    private String statsType;
    private String statsName;
    private String statsDate;

    public Long getRowNum() {
        return rowNum;
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getStatsId() {
        return statsId;
    }

    public void setStatsId(Long statsId) {
        this.statsId = statsId;
    }

    public String getStatsType() {
        return statsType;
    }

    public void setStatsType(String statsType) {
        this.statsType = statsType;
    }

    public String getStatsName() {
        return statsName;
    }

    public void setStatsName(String statsName) {
        this.statsName = statsName;
    }

    public String getStatsDate() {
        return statsDate;
    }

    public void setStatsDate(String statsDate) {
        this.statsDate = statsDate;
    }
}
