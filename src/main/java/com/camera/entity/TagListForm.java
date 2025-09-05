package com.camera.entity;

public class TagListForm {
    private String tagType;
    private String tagName1;
    private String tagName2;
    private Integer page;
    private Integer limit;

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getTagName1() {
        return tagName1;
    }

    public void setTagName1(String tagName1) {
        this.tagName1 = tagName1;
    }

    public String getTagName2() {
        return tagName2;
    }

    public void setTagName2(String tagName2) {
        this.tagName2 = tagName2;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
