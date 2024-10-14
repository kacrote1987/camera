package com.wision.entity;

import jnr.ffi.LibraryOption;

public class ChildListVo {
    private Long pageId;
    private String toolId;
    private String pageName;
    private String childName;
    private Long childOrder;
    private Long pageSel;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Long getChildOrder() {
        return childOrder;
    }

    public void setChildOrder(Long childOrder) {
        this.childOrder = childOrder;
    }

    public Long getPageSel() {
        return pageSel;
    }

    public void setPageSel(Long pageSel) {
        this.pageSel = pageSel;
    }
}
