package com.wision.entity;

public class ChildTblCol {
//    field: 'col1', title: '序号', width:'5%'
    private String type;
    private String fixed;
    private String field;
    private String title;
    private String width;
    private String toolbar;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getToolbar() {
        return toolbar;
    }

    public void setToolbar(String toolbar) {
        this.toolbar = toolbar;
    }
}
