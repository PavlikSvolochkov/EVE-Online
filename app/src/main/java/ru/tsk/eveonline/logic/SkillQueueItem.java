package ru.tsk.eveonline.logic;

public class SkillQueueItem {

    // <row queuePosition="0" typeID="3440" level="5" startSP="181020" endSP="1024000" startTime="2015-11-25 07:50:03" endTime="2015-12-11 14:06:09"/>

    private String queuePosition;
    private String typeID;
    private String level;
    private String startSP;
    private String endSP;
    private String startTime;
    private String endTime;

    public SkillQueueItem() {

    }

    public String getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(String queuePosition) {
        this.queuePosition = queuePosition;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStartSP() {
        return startSP;
    }

    public void setStartSP(String startSP) {
        this.startSP = startSP;
    }

    public String getEndSP() {
        return endSP;
    }

    public void setEndSP(String endSP) {
        this.endSP = endSP;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SkillQueueItem{" +
                "queuePosition='" + queuePosition + '\'' +
                ", typeID='" + typeID + '\'' +
                ", level='" + level + '\'' +
                ", startSP='" + startSP + '\'' +
                ", endSP='" + endSP + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
