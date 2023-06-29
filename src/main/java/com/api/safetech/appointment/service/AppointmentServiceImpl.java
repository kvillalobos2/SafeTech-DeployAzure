package com.api.safetech.appointment.service;

import com.api.safetech.appliance.domain.persistence.ApplianceRepository;
import com.api.safetech.appointment.domain.model.entity.Appointment;
import com.api.safetech.appointment.domain.persistence.AppointmentRepository;
import com.api.safetech.appointment.domain.service.AppointmentService;
import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.technical.domain.persistence.TechnicalRepository;
import com.api.safetech.user.domain.model.entity.User;
import com.api.safetech.user.domain.persistence.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final static String ENTITY = "Appointment";
    private final static String ENTITY2 = "User";
    private final static String ENTITY3 = "Technical";
    private final static String ENTITY4 = "Appliance";

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private ApplianceRepository applianceRepository;

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment create(Appointment request, Long userId, Long technicalId, Long applianceId) {
        var user = userRepository.findById(userId);
        if(user == null)
            throw new ResourceNotFoundException(ENTITY2, userId);

        var technical = technicalRepository.findById(technicalId);
        if(technical == null)
            throw new ResourceNotFoundException(ENTITY3, technicalId);

        var appliance = applianceRepository.findById(applianceId);
        if(appliance == null)
            throw new ResourceNotFoundException(ENTITY4, applianceId);

        request.setUser(user.get());
        request.setTechnical(technical.get());
        request.setAppliance(appliance.get());
        return appointmentRepository.save(request);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment request) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> appointmentRepository.save(
                        appointment.withProblemDescription(request.getProblemDescription())
                                .withScheduledAt(request.getScheduledAt())
                                .withAddress(request.getAddress())
                                .withStatus(request.getStatus())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment delete(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointment);
                    return appointment;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public List<Appointment> getByUserId(Long userId) {
        var user = userRepository.findById(userId);
        if(user == null)
            throw new ResourceNotFoundException(ENTITY2, userId);

        return appointmentRepository.findByUserId(userId);
    }

    @Override
    public List<Appointment> getByTechnicalId(Long technicalId) {
        var technical = technicalRepository.findById(technicalId);
        if(technical == null)
            throw new ResourceNotFoundException(ENTITY3, technicalId);

        return appointmentRepository.findByTechnicalId(technicalId);
    }

    @Override
    public List<Appointment> getByUserIdAndTechnicalId(Long userId, Long technicalId) {
        var user = userRepository.findById(userId);
        if(user == null)
            throw new ResourceNotFoundException(ENTITY2, userId);

        var technical = technicalRepository.findById(technicalId);
        if(technical == null)
            throw new ResourceNotFoundException(ENTITY3, technicalId);

        return appointmentRepository.findByUserIdAndTechnicalId(userId, technicalId);
    }
}
