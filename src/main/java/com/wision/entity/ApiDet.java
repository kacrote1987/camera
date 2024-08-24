package com.wision.entity;

public class ApiDet {
    private String action;
    private Long apiId;
    private String apiName;
    private String apiAddr;
    private String appKey;
    private String appSecret;
    private String requestTime;
    private String sign1;
    private String apiNet;
    private String apiExplain;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getSign1() {
        return sign1;
    }

    public void setSign1(String sign1) {
        this.sign1 = sign1;
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
}
