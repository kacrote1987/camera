package com.wision.entity;

public class SourDetVo {
    private Long relatId;
    private String relatName;
    private String layoutType;
    private Long selfId;
    private String tblName;
    private String selfCol;
    private Long targetId;
    private String targetCol;

    public Long getRelatId() {
        return relatId;
    }

    public void setRelatId(Long relatId) {
        this.relatId = relatId;
    }

    public String getRelatName() {
        return relatName;
    }

    public void setRelatName(String relatName) {
        this.relatName = relatName;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public Long getSelfId() {
        return selfId;
    }

    public void setSelfId(Long selfId) {
        this.selfId = selfId;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    public String getSelfCol() {
        return selfCol;
    }

    public void setSelfCol(String selfCol) {
        this.selfCol = selfCol;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetCol() {
        return targetCol;
    }

    public void setTargetCol(String targetCol) {
        this.targetCol = targetCol;
    }
}
