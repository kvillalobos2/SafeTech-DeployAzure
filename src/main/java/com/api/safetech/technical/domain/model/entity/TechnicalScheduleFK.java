package com.api.safetech.technical.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalScheduleFK implements Serializable {

    @Column(name = "technical_id", nullable = false)
    private Long technicalId;

    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

}
