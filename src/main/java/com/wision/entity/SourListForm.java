package com.wision.entity;

public class SourListForm {
    private String sourId;
    private String sourName;
    private String sourCont;
    private String sourFrom;
    private String sourType;
    private Integer page;
    private Integer limit;

    public String getSourId() {
        return sourId;
    }

    public void setSourId(String sourId) {
        this.sourId = sourId;
    }

    public String getSourName() {
        return sourName;
    }

    public void setSourName(String sourName) {
        this.sourName = sourName;
    }

    public String getSourCont() {
        return sourCont;
    }

    public void setSourCont(String sourCont) {
        this.sourCont = sourCont;
    }

    public String getSourFrom() {
        return sourFrom;
    }

    public void setSourFrom(String sourFrom) {
        this.sourFrom = sourFrom;
    }

    public String getSourType() {
        return sourType;
    }

    public void setSourType(String sourType) {
        this.sourType = sourType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
