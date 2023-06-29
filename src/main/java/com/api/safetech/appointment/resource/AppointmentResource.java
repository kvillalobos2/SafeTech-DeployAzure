package com.api.safetech.appointment.resource;

import com.api.safetech.appliance.domain.model.entity.Appliance;
import com.api.safetech.appliance.resource.ApplianceResource;
import com.api.safetech.appointment.domain.model.entity.Status;
import com.api.safetech.technical.domain.model.entity.Technical;
import com.api.safetech.technical.resource.TechnicalResource;
import com.api.safetech.user.domain.model.entity.User;
import com.api.safetech.user.resource.UserResource;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String problemDescription;
    private Date scheduledAt;
    private String address;
    private Status status;
    private UserResource user;
    private TechnicalResource technical;
    private ApplianceResource appliance;
}
