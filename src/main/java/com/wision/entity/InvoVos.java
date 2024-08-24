package com.wision.entity;

import java.util.List;

public class InvoVos {
    private List<InvoVo> invoVo;
    private Long invoTotal;

    public List<InvoVo> getInvoVo() {
        return invoVo;
    }

    public void setInvoVo(List<InvoVo> invoVo) {
        this.invoVo = invoVo;
    }

    public Long getInvoTotal() {
        return invoTotal;
    }

    public void setInvoTotal(Long invoTotal) {
        this.invoTotal = invoTotal;
    }
}
