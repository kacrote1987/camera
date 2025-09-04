package com.project.entity;

public class ProjCostForm {
    private Long rowNum;
    private Long projId;
    private Long assId;
    private String assType;
    private String brandName;
    private String assNum;
    private String assPrice;
    private String assTotal;

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

    public Long getAssId() {
        return assId;
    }

    public void setAssId(Long assId) {
        this.assId = assId;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAssNum() {
        return assNum;
    }

    public void setAssNum(String assNum) {
        this.assNum = assNum;
    }

    public String getAssPrice() {
        return assPrice;
    }

    public void setAssPrice(String assPrice) {
        this.assPrice = assPrice;
    }

    public String getAssTotal() {
        return assTotal;
    }

    public void setAssTotal(String assTotal) {
        this.assTotal = assTotal;
    }
}
