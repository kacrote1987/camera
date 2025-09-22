package com.camera.entity;

public class GanttDet {
    private String action;
    private Long projId;
    private Long ganttId;
    private String field;
    private String value;
    private String dictValue;  //五统一设备参数配置
    private String ganttType;
    private String ganttProce;
    private String ganttTime1;
    private String ganttTime2;
    private String total;
    private String sum;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public Long getGanttId() {
        return ganttId;
    }

    public void setGanttId(Long ganttId) {
        this.ganttId = ganttId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getGanttType() {
        return ganttType;
    }

    public void setGanttType(String ganttType) {
        this.ganttType = ganttType;
    }

    public String getGanttProce() {
        return ganttProce;
    }

    public void setGanttProce(String ganttProce) {
        this.ganttProce = ganttProce;
    }

    public String getGanttTime1() {
        return ganttTime1;
    }

    public void setGanttTime1(String ganttTime1) {
        this.ganttTime1 = ganttTime1;
    }

    public String getGanttTime2() {
        return ganttTime2;
    }

    public void setGanttTime2(String ganttTime2) {
        this.ganttTime2 = ganttTime2;
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
