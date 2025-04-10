package com.wision.entity;

public class LogVo {
    private String diaryDate;
    private String diaryNote;
    private String logName;
    private String logContent;
    private Long logId;
    private String logDept;
    private String logState;

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

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getLogDept() {
        return logDept;
    }

    public void setLogDept(String logDept) {
        this.logDept = logDept;
    }

    public String getLogState() {
        return logState;
    }

    public void setLogState(String logState) {
        this.logState = logState;
    }
}
