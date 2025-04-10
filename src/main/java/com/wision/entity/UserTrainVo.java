package com.wision.entity;

public class UserTrainVo {
    private Long rowNum;
    private Long trainId;
    private String trainStart;
    private String trainEnd;
    private String trainAddr;
    private String trainName;
    private String trainAttr;
    private String trainScore;

    public Long getRowNum() {
        return rowNum;
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getTrainStart() {
        return trainStart;
    }

    public void setTrainStart(String trainStart) {
        this.trainStart = trainStart;
    }

    public String getTrainEnd() {
        return trainEnd;
    }

    public void setTrainEnd(String trainEnd) {
        this.trainEnd = trainEnd;
    }

    public String getTrainAddr() {
        return trainAddr;
    }

    public void setTrainAddr(String trainAddr) {
        this.trainAddr = trainAddr;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainAttr() {
        return trainAttr;
    }

    public void setTrainAttr(String trainAttr) {
        this.trainAttr = trainAttr;
    }

    public String getTrainScore() {
        return trainScore;
    }

    public void setTrainScore(String trainScore) {
        this.trainScore = trainScore;
    }
}
