package com.api.safetech.technical.domain.persistence;

import com.api.safetech.technical.domain.model.entity.TechnicalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalScheduleRepository extends JpaRepository<TechnicalSchedule, Long> {}
