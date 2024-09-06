package com.wision.entity;

public class SourDetVo {
    private Long relatId;
    private String relatName;
    private String layoutType;
    private Long tblId;
    private String tblName;

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

    public Long getTblId() {
        return tblId;
    }

    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }
}
