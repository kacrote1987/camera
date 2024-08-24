package com.wision.entity;

public class RelatDetVo {
    private Long relatId;
    private Long toolId;
    private String relatName;
    private String relatOpen;
    private String layoutType;
    private String mainTbl;
    private String basicTbl;

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

    public String getRelatName() {
        return relatName;
    }

    public void setRelatName(String relatName) {
        this.relatName = relatName;
    }

    public String getRelatOpen() {
        return relatOpen;
    }

    public void setRelatOpen(String relatOpen) {
        this.relatOpen = relatOpen;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public String getMainTbl() {
        return mainTbl;
    }

    public void setMainTbl(String mainTbl) {
        this.mainTbl = mainTbl;
    }

    public String getBasicTbl() {
        return basicTbl;
    }

    public void setBasicTbl(String basicTbl) {
        this.basicTbl = basicTbl;
    }
}
