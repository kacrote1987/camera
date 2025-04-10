package com.wision.entity;

public class ApiList {
    private Long apiId;
    private String apiName;
    private String apiAddr;
    private String apiNet;
    private String apiExplain;
    private Integer page;
    private Integer limit;

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiAddr() {
        return apiAddr;
    }

    public void setApiAddr(String apiAddr) {
        this.apiAddr = apiAddr;
    }

    public String getApiNet() {
        return apiNet;
    }

    public void setApiNet(String apiNet) {
        this.apiNet = apiNet;
    }

    public String getApiExplain() {
        return apiExplain;
    }

    public void setApiExplain(String apiExplain) {
        this.apiExplain = apiExplain;
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
