package com.wision.entity;

public class InvoDetForm {
    private String action;
    private Long invoId;
    private Long detId;
    private String field;
    private String value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getInvoId() {
        return invoId;
    }

    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }

    public Long getDetId() {
        return detId;
    }

    public void setDetId(Long detId) {
        this.detId = detId;
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
