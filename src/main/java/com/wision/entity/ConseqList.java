package com.wision.entity;

public class ConseqList {
    private Long conseqId;
    private String conseqName;
    private String purchaseState;
    private String bidState;
    private String contractState;

    public Long getConseqId() {
        return conseqId;
    }

    public void setConseqId(Long conseqId) {
        this.conseqId = conseqId;
    }

    public String getConseqName() {
        return conseqName;
    }

    public void setConseqName(String conseqName) {
        this.conseqName = conseqName;
    }

    public String getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(String purchaseState) {
        this.purchaseState = purchaseState;
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
}
