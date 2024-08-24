package com.wision.entity;

import java.util.List;

public class ChildTblSelVo {
    private List<ChildTblCol> childTblCol;
    private List<ChildTblCol> childTblSel;

    public List<ChildTblCol> getChildTblCol() {
        return childTblCol;
    }

    public void setChildTblCol(List<ChildTblCol> childTblCol) {
        this.childTblCol = childTblCol;
    }

    public List<ChildTblCol> getChildTblSel() {
        return childTblSel;
    }

    public void setChildTblSel(List<ChildTblCol> childTblSel) {
        this.childTblSel = childTblSel;
    }
}
