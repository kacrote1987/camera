package com.wision.entity;

public class ScoreForm {
    private String action;
    private Long statsId;
    private Long scoreId;
    private String field;
    private String value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getStatsId() {
        return statsId;
    }

    public void setStatsId(Long statsId) {
        this.statsId = statsId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
