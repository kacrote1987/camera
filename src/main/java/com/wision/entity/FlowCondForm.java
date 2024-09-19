package com.wision.entity;

public class FlowCondForm {
    private Long relatId;
    private String relatName;
    private String layoutType;
    private Long stepSize;

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

    public Long getStepSize() {
        return stepSize;
    }

    public void setStepSize(Long stepSize) {
        this.stepSize = stepSize;
    }
}
