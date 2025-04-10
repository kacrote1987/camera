package com.wision.entity;

public class RelatForm {
    private Long relatId;
    private String relatName;
    private String layoutType;
    private Long tblId;
    private String mainTbl;

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

    public String getMainTbl() {
        return mainTbl;
    }

    public void setMainTbl(String mainTbl) {
        this.mainTbl = mainTbl;
    }
}
