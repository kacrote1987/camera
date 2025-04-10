package com.wision.entity;

import org.springframework.web.multipart.MultipartFile;

public class FormData {
    private MultipartFile file;
    private String prodId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }
}
