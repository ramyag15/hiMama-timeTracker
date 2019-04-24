package org.himama.timetracker.data;

import org.springframework.data.repository.CrudRepository;

public interface UserEventsInterface extends CrudRepository<UserEvents, Long> {
}
