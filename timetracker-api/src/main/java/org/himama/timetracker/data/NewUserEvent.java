package org.himama.timetracker.data;


public class NewUserEvent {
    private String userName;
    private EventType eventType;
    private String checkTime;

    public NewUserEvent(String userName, EventType eventType, String checkTime) {
        this.userName = userName;
        this.eventType = eventType;
        this.checkTime = checkTime;
    }

    protected NewUserEvent() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public String toString() {
        return "NewUserEvent{" +
                "userName='" + userName + '\'' +
                ", eventType=" + eventType +
                ", checkTime=" + checkTime +
                '}';
    }
}
