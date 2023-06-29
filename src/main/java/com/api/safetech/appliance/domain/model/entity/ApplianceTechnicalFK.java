package com.api.safetech.appliance.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceTechnicalFK implements Serializable {

    @Column(name = "technical_id", nullable = false)
    private Long technicalId;

    @Column(name= "appliance_id", nullable = false)
    private Long applianceId;
}
