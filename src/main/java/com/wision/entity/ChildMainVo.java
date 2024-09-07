package com.wision.entity;

import java.util.List;

public class ChildMainVo {
    private String prodName;
    private List<ChildMenuVo> childMenuVo;

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public List<ChildMenuVo> getChildMenuVo() {
        return childMenuVo;
    }

    public void setChildMenuVo(List<ChildMenuVo> childMenuVo) {
        this.childMenuVo = childMenuVo;
    }
}
