package org.himama.timetracker.data;

import javax.persistence.*;

@Entity
@Table(schema = "public")
public class Events {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private EventType eventType;

    protected Events() {}

    public Events(Long id, EventType eventType) {
        this.id = id;
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
