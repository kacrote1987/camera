package com.wision.entity;

public class InvoMembVo {
    private Long membId;
    private String membDept;
    private String membType;
    private String membSurp;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembDept() {
        return membDept;
    }

    public void setMembDept(String membDept) {
        this.membDept = membDept;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getMembSurp() {
        return membSurp;
    }

    public void setMembSurp(String membSurp) {
        this.membSurp = membSurp;
    }
}
