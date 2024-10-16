package com.wision.entity;

import java.util.List;

public class FlowCondVo {
    private String relatName;
    private String layoutType;
    private String relatState;
    private String mainCol;
    private String relatCol;
    private Long stepSize;

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

    public String getRelatState() {
        return relatState;
    }

    public void setRelatState(String relatState) {
        this.relatState = relatState;
    }

    public String getMainCol() {
        return mainCol;
    }

    public void setMainCol(String mainCol) {
        this.mainCol = mainCol;
    }

    public String getRelatCol() {
        return relatCol;
    }

    public void setRelatCol(String relatCol) {
        this.relatCol = relatCol;
    }

    public Long getStepSize() {
        return stepSize;
    }

    public void setStepSize(Long stepSize) {
        this.stepSize = stepSize;
    }
}
