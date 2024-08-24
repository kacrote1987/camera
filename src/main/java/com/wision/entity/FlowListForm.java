package com.wision.entity;

public class FlowListForm {
    private String action;
    private Long relatId;
    private Long extId;
    private String field;
    private String value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getRelatId() {
        return relatId;
    }

    public void setRelatId(Long relatId) {
        this.relatId = relatId;
    }

    public Long getExtId() {
        return extId;
    }

    public void setExtId(Long extId) {
        this.extId = extId;
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
