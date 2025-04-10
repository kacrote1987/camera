package com.wision.entity;

import java.util.List;

public class ProdViewVo {
    private Long prodId;
    private String prodName;
    private List<MenuListVo> menuList;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public List<MenuListVo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuListVo> menuList) {
        this.menuList = menuList;
    }
}
