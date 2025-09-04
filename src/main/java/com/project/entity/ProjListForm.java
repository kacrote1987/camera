package com.project.entity;

public class ProjListForm {
    private Long rowNum;
    private Long projId;
    private String projType;
    private String projBusin;
    private String projName;
    private String projManager;
    private String bidState;
    private String contractState;
    private String budgetAmount;
    private String budgetPercent;
    private String budgetComplete;
    private String projStepcode;
    private Integer page;
    private Integer limit;
    private Integer stepVal;

    public Long getRowNum() {
        return rowNum;
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public String getProjType() {
        return projType;
    }

    public void setProjType(String projType) {
        this.projType = projType;
    }

    public String getProjBusin() {
        return projBusin;
    }

    public void setProjBusin(String projBusin) {
        this.projBusin = projBusin;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjManager() {
        return projManager;
    }

    public void setProjManager(String projManager) {
        this.projManager = projManager;
    }

    public String getBidState() {
        return bidState;
    }

    public void setBidState(String bidState) {
        this.bidState = bidState;
    }

    public String getContractState() {
        return contractState;
    }

    public void setContractState(String contractState) {
        this.contractState = contractState;
    }

    public String getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(String budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getBudgetPercent() {
        return budgetPercent;
    }

    public void setBudgetPercent(String budgetPercent) {
        this.budgetPercent = budgetPercent;
    }

    public String getBudgetComplete() {
        return budgetComplete;
    }

    public void setBudgetComplete(String budgetComplete) {
        this.budgetComplete = budgetComplete;
    }

    public String getProjStepcode() {
        return projStepcode;
    }

    public void setProjStepcode(String projStepcode) {
        this.projStepcode = projStepcode;
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

    public Integer getStepVal() {
        return stepVal;
    }

    public void setStepVal(Integer stepVal) {
        this.stepVal = stepVal;
    }
}
