package com.wision.entity;

public class CostForm {
    private Long costId;
    private String action;
    private String inspSn;
    private String inspNo;
    private String costUnitname;
    private String unitName;
    private String equAreacode;
    private String costState;
    private String costNo;
    private String costPaydate;
    private String costRegdate;
    private Long page;
    private Long limit;

    public Long getCostId() {
        return costId;
    }

    public void setCostId(Long costId) {
        this.costId = costId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInspSn() {
        return inspSn;
    }

    public void setInspSn(String inspSn) {
        this.inspSn = inspSn;
    }

    public String getInspNo() {
        return inspNo;
    }

    public void setInspNo(String inspNo) {
        this.inspNo = inspNo;
    }

    public String getCostUnitname() {
        return costUnitname;
    }

    public void setCostUnitname(String costUnitname) {
        this.costUnitname = costUnitname;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getEquAreacode() {
        return equAreacode;
    }

    public void setEquAreacode(String equAreacode) {
        this.equAreacode = equAreacode;
    }

    public String getCostState() {
        return costState;
    }

    public void setCostState(String costState) {
        this.costState = costState;
    }

    public String getCostNo() {
        return costNo;
    }

    public void setCostNo(String costNo) {
        this.costNo = costNo;
    }

    public String getCostPaydate() {
        return costPaydate;
    }

    public void setCostPaydate(String costPaydate) {
        this.costPaydate = costPaydate;
    }

    public String getCostRegdate() {
        return costRegdate;
    }

    public void setCostRegdate(String costRegdate) {
        this.costRegdate = costRegdate;
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
