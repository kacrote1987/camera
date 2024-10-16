package com.wision.entity;

import java.util.List;

public class BasicSourVo {
   private String relatName;
   private String layoutType;
   private List<SourTblVo> basicSourTblVo;

    public String getRelatName() {
        return relatName;
    }

    public void setRelatName(String relatName) {
        this.relatName = relatName;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public List<SourTblVo> getBasicSourTblVo() {
        return basicSourTblVo;
    }

    public void setBasicSourTblVo(List<SourTblVo> basicSourTblVo) {
        this.basicSourTblVo = basicSourTblVo;
    }
}
