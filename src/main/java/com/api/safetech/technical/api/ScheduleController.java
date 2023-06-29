package com.api.safetech.technical.api;

import com.api.safetech.technical.domain.service.ScheduleService;
import com.api.safetech.technical.mapping.ScheduleMapper;
import com.api.safetech.technical.resource.CreateScheduleResource;
import com.api.safetech.technical.resource.ScheduleResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Schedule")
@RestController
@RequestMapping("/api/v1/schedules")
@CrossOrigin
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleMapper mapper;

    @Operation(summary = "Get Schedules", description = "Get All Schedules")
    @GetMapping
    public List<ScheduleResource> getAllSchedules()
    {
        return mapper.toResource(scheduleService.getAll());
    }

    @Operation(summary = "Get schedule by Id", description = "Get schedule by Id")
    @GetMapping("{scheduleId}")
    public ScheduleResource getScheduleById(@PathVariable Long scheduleId)
    {
        return mapper.toResource(scheduleService.getById(scheduleId));
    }

    @Operation(summary = "Create Schedule", description = "Create Schedule")
    @PostMapping
    public ScheduleResource createSchedule(@RequestBody CreateScheduleResource request)
    {
        return mapper.toResource(scheduleService.create(mapper.toModel(request)));
    }
}
