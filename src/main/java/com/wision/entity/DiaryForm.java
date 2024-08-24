package com.wision.entity;

public class DiaryForm {
    private String diaryDate;
    private String diaryNote;
    private String diaryType;
    private Long typeId;
    private Long userId;
    private String logName;
    private String logContent;

    public String getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(String diaryDate) {
        this.diaryDate = diaryDate;
    }

    public String getDiaryNote() {
        return diaryNote;
    }

    public void setDiaryNote(String diaryNote) {
        this.diaryNote = diaryNote;
    }

    public String getDiaryType() {
        return diaryType;
    }

    public void setDiaryType(String diaryType) {
        this.diaryType = diaryType;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }
}
