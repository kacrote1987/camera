package com.wision.entity;

import java.util.List;

public class MenuTreeVo {
    private String title;
    private Long id;
    private String spread;
    private List<children> children;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public List<com.wision.entity.children> getChildren() {
        return children;
    }

    public void setChildren(List<com.wision.entity.children> children) {
        this.children = children;
    }
}
