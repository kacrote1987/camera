package com.project.entity;

public class MeetListForm {
    private Long rowNum;
    private Long meetId;
    private Long projId;
    private String meetTopic;
    private String meetTime;
    private String meetTime1;
    private String meetTime2;
    private String meetAddr;
    private String meetHost;
    private String meetMember;
    private Integer page;
    private Integer limit;

    public Long getRowNum() {
        return rowNum;
    }

    public void setRowNum(Long rowNum) {
        this.rowNum = rowNum;
    }

    public Long getMeetId() {
        return meetId;
    }

    public void setMeetId(Long meetId) {
        this.meetId = meetId;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public String getMeetTopic() {
        return meetTopic;
    }

    public void setMeetTopic(String meetTopic) {
        this.meetTopic = meetTopic;
    }

    public String getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(String meetTime) {
        this.meetTime = meetTime;
    }

    public String getMeetTime1() {
        return meetTime1;
    }

    public void setMeetTime1(String meetTime1) {
        this.meetTime1 = meetTime1;
    }

    public String getMeetTime2() {
        return meetTime2;
    }

    public void setMeetTime2(String meetTime2) {
        this.meetTime2 = meetTime2;
    }

    public String getMeetAddr() {
        return meetAddr;
    }

    public void setMeetAddr(String meetAddr) {
        this.meetAddr = meetAddr;
    }

    public String getMeetHost() {
        return meetHost;
    }

    public void setMeetHost(String meetHost) {
        this.meetHost = meetHost;
    }

    public String getMeetMember() {
        return meetMember;
    }

    public void setMeetMember(String meetMember) {
        this.meetMember = meetMember;
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
