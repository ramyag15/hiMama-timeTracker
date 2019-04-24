package org.himama.timetracker.data;

public enum EventType {
    IN_TIME(1), OUT_TIME(2);

    private final Integer id;
    EventType(Integer id) { this.id = id; }
    public Integer getValue() { return id; }
};