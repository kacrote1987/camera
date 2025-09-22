package com.camera.entity;

public class TagList {
    private Long rowNum;
    private Long tagId;
    private String tagType;
    private String tagName1;
    private String tagCode1;
    private String tagName2;
    private String tagCode2;
    private String tagName3;
    private String tagCode3;
    private Integer page;
    private Integer limit;

    public Long getRowNum() {
        return rowNum;
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

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

    public String getTagCode1() {
        return tagCode1;
    }

    public void setTagCode1(String tagCode1) {
        this.tagCode1 = tagCode1;
    }

    public String getTagName2() {
        return tagName2;
    }

    public void setTagName2(String tagName2) {
        this.tagName2 = tagName2;
    }

    public String getTagCode2() {
        return tagCode2;
    }

    public void setTagCode2(String tagCode2) {
        this.tagCode2 = tagCode2;
    }

    public String getTagName3() {
        return tagName3;
    }

    public void setTagName3(String tagName3) {
        this.tagName3 = tagName3;
    }

    public String getTagCode3() {
        return tagCode3;
    }

    public void setTagCode3(String tagCode3) {
        this.tagCode3 = tagCode3;
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
