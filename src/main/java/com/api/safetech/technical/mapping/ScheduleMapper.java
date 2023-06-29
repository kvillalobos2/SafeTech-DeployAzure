package com.api.safetech.technical.mapping;

import com.api.safetech.shared.mapping.EnhancedModelMapper;
import com.api.safetech.technical.domain.model.entity.Schedule;
import com.api.safetech.technical.resource.CreateScheduleResource;
import com.api.safetech.technical.resource.ScheduleResource;
import com.api.safetech.technical.resource.UpdateScheduleResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScheduleMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public ScheduleResource toResource(Schedule model)
    {
        return mapper.map(model, ScheduleResource.class);
    }

    public List<ScheduleResource> toResource(List<Schedule> model)
    {
        return mapper.mapList(model, ScheduleResource.class);
    }

    public Schedule toModel(CreateScheduleResource resource)
    {
        return mapper.map(resource, Schedule.class);
    }

    public Schedule toModel(UpdateScheduleResource resource)
    {
        return mapper.map(resource, Schedule.class);
    }
}

