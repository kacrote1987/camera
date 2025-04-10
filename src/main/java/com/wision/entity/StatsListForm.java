package com.wision.entity;

public class StatsListForm {
    private String statsType;
    private String statsName;
    private String statsYear;
    private String statsMonth;
    private Long page;
    private Long limit;

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

    public String getStatsYear() {
        return statsYear;
    }

    public void setStatsYear(String statsYear) {
        this.statsYear = statsYear;
    }

    public String getStatsMonth() {
        return statsMonth;
    }

    public void setStatsMonth(String statsMonth) {
        this.statsMonth = statsMonth;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}
