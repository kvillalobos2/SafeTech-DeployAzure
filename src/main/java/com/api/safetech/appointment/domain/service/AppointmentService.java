package com.api.safetech.appointment.domain.service;

import com.api.safetech.appointment.domain.model.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment getById(Long appointmentId);
    Appointment create(Appointment appointment, Long userId, Long technicalId, Long applianceId);
    Appointment update(Long appointmentId, Appointment appointment);
    Appointment delete(Long appointmentId);
    List<Appointment> getByUserId(Long userId);
    List<Appointment> getByTechnicalId(Long technicalId);
    List<Appointment> getByUserIdAndTechnicalId(Long userId, Long technicalId);
}
