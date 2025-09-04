package com.project.entity;

public class GanttDispForm {
    private Long id;
    private Long pid;
    private String projectName;
    private String projectElem;
    private String planStartAt;
    private String planEndAt;
    private String startAt;
    private String endAt;
    private String persent;
    private String dur;
    private String total;
    private String sum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectElem() {
        return projectElem;
    }

    public void setProjectElem(String projectElem) {
        this.projectElem = projectElem;
    }

    public String getPlanStartAt() {
        return planStartAt;
    }

    public void setPlanStartAt(String planStartAt) {
        this.planStartAt = planStartAt;
    }

    public String getPlanEndAt() {
        return planEndAt;
    }

    public void setPlanEndAt(String planEndAt) {
        this.planEndAt = planEndAt;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getPersent() {
        return persent;
    }

    public void setPersent(String persent) {
        this.persent = persent;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
