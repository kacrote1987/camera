package com.wision.entity;

public class RelatDetVo {
    private Long relatId;
    private Long toolId;
    private Long tblId;
    private String relatName;
    private String layoutType;
    private String relateCol;
    private String mainCol;

    public Long getRelatId() {
        return relatId;
    }

    public void setRelatId(Long relatId) {
        this.relatId = relatId;
    }

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public Long getTblId() {
        return tblId;
    }

    public void setTblId(Long tblId) {
        this.tblId = tblId;
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

    public String getRelateCol() {
        return relateCol;
    }

    public void setRelateCol(String relateCol) {
        this.relateCol = relateCol;
    }

    public String getMainCol() {
        return mainCol;
    }

    public void setMainCol(String mainCol) {
        this.mainCol = mainCol;
    }
}
