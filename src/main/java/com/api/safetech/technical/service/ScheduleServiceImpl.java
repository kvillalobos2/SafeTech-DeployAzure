package com.api.safetech.technical.service;

import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.technical.domain.model.entity.Schedule;
import com.api.safetech.technical.domain.persistence.ScheduleRepository;
import com.api.safetech.technical.domain.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final static String ENTITY = "Schedule";

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule create(Schedule request) {
        return scheduleRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).map(schedule -> {
            scheduleRepository.delete(schedule);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, scheduleId));
    }

    @Override
    public Schedule getById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, scheduleId));
    }
}
