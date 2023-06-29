package com.api.safetech.technical.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="technical_schedule")
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalSchedule {

    @EmbeddedId
    private TechnicalScheduleFK technicalScheduleFK;

    @ManyToOne
    @MapsId("technicalId")
    private Technical technical;

    @ManyToOne
    @MapsId("scheduleId")
    private Schedule schedule;
}
