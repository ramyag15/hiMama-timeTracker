package org.himama.timetracker.data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public")
public class UserEvents {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long eventId;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime eventTime = LocalDateTime.now();


    protected UserEvents() {}
    public UserEvents(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "UserEvents{" +
                "userId=" + userId +
                ", eventId=" + eventId +
                ", eventTime=" + eventTime +
                '}';
    }
}
