package com.wision.entity;

import java.util.Date;

public class InstrListVo {
    private Long rowNum;
    private Long instrId;
    private String instrNo;
    private String instrName;
    private String instrOwner;
    private Date instrTime;
    private String instrState;

    public Long getRowNum() {
        return rowNum;
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getInstrId() {
        return instrId;
    }

    public void setInstrId(Long instrId) {
        this.instrId = instrId;
    }

    public String getInstrNo() {
        return instrNo;
    }

    public void setInstrNo(String instrNo) {
        this.instrNo = instrNo;
    }

    public String getInstrName() {
        return instrName;
    }

    public void setInstrName(String instrName) {
        this.instrName = instrName;
    }

    public String getInstrOwner() {
        return instrOwner;
    }

    public void setInstrOwner(String instrOwner) {
        this.instrOwner = instrOwner;
    }

    public Date getInstrTime() {
        return instrTime;
    }

    public void setInstrTime(Date instrTime) {
        this.instrTime = instrTime;
    }

    public String getInstrState() {
        return instrState;
    }

    public void setInstrState(String instrState) {
        this.instrState = instrState;
    }
}
