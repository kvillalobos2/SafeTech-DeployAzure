package com.api.safetech.appointment.resource;

import com.api.safetech.appointment.domain.model.entity.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResource {
    @NotNull
    @NotBlank
    private String problemDescription;

    @NotNull
    private Date scheduledAt;

    @NotNull
    @NotBlank
    private String address;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

}
