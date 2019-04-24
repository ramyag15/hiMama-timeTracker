package org.himama.timetracker.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventsInterface extends CrudRepository<Events, Long> {
    @Query(value = "SELECT id from events where event_type=(:eventType);", nativeQuery = true)
    Long getEventIdByType(@Param("eventType") String eventType);

    @Query(value = "SELECT event_type from events where id=(:eventId);", nativeQuery = true)
    String getEventTypeById(@Param("eventId") Long eventId);
}
