package com.api.safetech.technical.domain.persistence;

import com.api.safetech.technical.domain.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "select * from schedule where id in(Select b.schedule_id From technical_schedule b Where b.technical_id = :technical_id)", nativeQuery = true)
    List<Schedule> findByTechnicalId(@Param("technical_id") Long technical_id);
}
