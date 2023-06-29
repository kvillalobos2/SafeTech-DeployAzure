package com.api.safetech.appliance.domain.model.entity;

import com.api.safetech.technical.domain.model.entity.Technical;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="technical_appliance")
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceTechnical {

    @EmbeddedId
    private ApplianceTechnicalFK applianceTechnicalFK;

    @ManyToOne
    @MapsId("technicalId")
    private Technical technical;

    @ManyToOne
    @MapsId("applianceId")
    private Appliance appliance;

}
