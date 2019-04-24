package org.himama.timetracker.data;

public class UserEventsResponse {
    private String userName;
    private Long userId;
    private String eventType;
    private String eventTime;
    private Long userEventId;

    protected UserEventsResponse() {}

    public UserEventsResponse(String userName, Long userId, String eventType, String eventTime, Long userEventId) {
        this.userName = userName;
        this.userId = userId;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.userEventId = userEventId;
    }

    public Long getUserEventId() {
        return userEventId;
    }

    public void setUserEventId(Long userEventId) {
        this.userEventId = userEventId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "UserEventsResponse{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", eventType='" + eventType + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}
