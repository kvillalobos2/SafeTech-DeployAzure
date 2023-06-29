package com.api.safetech.appointment.domain.persistence;

import com.api.safetech.appointment.domain.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUserId(Long userId);
    List<Appointment> findByTechnicalId(Long technicalId);
    List<Appointment> findByUserIdAndTechnicalId(Long userId, Long technicalId);
}
