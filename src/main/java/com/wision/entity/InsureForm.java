package com.wision.entity;

public class InsureForm {
    private Long id;
    private String recipientName;
    private String idCard;
    private String lz;
    private String dy;
    private String fh;
    private String cb;
    private String jy;
    private String cbChk;
    private String jyChk;
    private Integer page;
    private Integer limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLz() {
        return lz;
    }

    public void setLz(String lz) {
        this.lz = lz;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy;
    }

    public String getCbChk() {
        return cbChk;
    }

    public void setCbChk(String cbChk) {
        this.cbChk = cbChk;
    }

    public String getJyChk() {
        return jyChk;
    }

    public void setJyChk(String jyChk) {
        this.jyChk = jyChk;
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
