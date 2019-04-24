package org.himama.timetracker.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersInterface extends CrudRepository<Users, Long> {
    @Query(value = "SELECT id from users where username=(:userName);", nativeQuery = true)
    Long getUserIdByUName(@Param("userName") String userName);
}
