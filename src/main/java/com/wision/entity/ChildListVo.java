package com.wision.entity;

public class ChildListVo {
    private Long pageId;
    private String pageName;
    private String sourcePath;
    private String destinyPath;
    private String pageOrder;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getDestinyPath() {
        return destinyPath;
    }

    public void setDestinyPath(String destinyPath) {
        this.destinyPath = destinyPath;
    }

    public String getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(String pageOrder) {
        this.pageOrder = pageOrder;
    }
}
