package com.wision.entity;

import java.util.List;

public class ChildTblDetForm {
    private Long menuId;
    private Long id;
    private List<BasicCol> childTblHeadDet;
    private ChildTblForm childTblContDet;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BasicCol> getChildTblHeadDet() {
        return childTblHeadDet;
    }

    public void setChildTblHeadDet(List<BasicCol> childTblHeadDet) {
        this.childTblHeadDet = childTblHeadDet;
    }

    public ChildTblForm getChildTblContDet() {
        return childTblContDet;
    }

    public void setChildTblContDet(ChildTblForm childTblContDet) {
        this.childTblContDet = childTblContDet;
    }
}
