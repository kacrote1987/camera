package com.wision.entity;

public class BasicTblList {
    private String action;
    private Long tblId;
    private Long prodId;
    private String tblName;
    private String tblCode;
    private Integer page;
    private Integer limit;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getTblId() {
        return tblId;
    }

    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    public String getTblCode() {
        return tblCode;
    }

    public void setTblCode(String tblCode) {
        this.tblCode = tblCode;
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
