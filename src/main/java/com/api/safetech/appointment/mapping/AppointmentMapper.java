package com.api.safetech.appointment.mapping;

import com.api.safetech.appointment.domain.model.entity.Appointment;
import com.api.safetech.appointment.resource.AppointmentResource;
import com.api.safetech.appointment.resource.CreateAppointmentResource;
import com.api.safetech.appointment.resource.UpdateAppointmentResource;
import com.api.safetech.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AppointmentMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public AppointmentResource toResource(Appointment model){
        return mapper.map(model, AppointmentResource.class);
    }

    public List<AppointmentResource> toResource(List<Appointment>model){
        return mapper.mapList(model, AppointmentResource.class);
    }

    public Appointment toModel(CreateAppointmentResource resource){
        return mapper.map(resource, Appointment.class);
    }

    public Appointment toModel(UpdateAppointmentResource resource){
        return mapper.map(resource, Appointment.class);
    }
}
