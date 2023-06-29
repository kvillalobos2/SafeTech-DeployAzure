package com.api.safetech.technical.api;

import com.api.safetech.appliance.domain.model.entity.Appliance;
import com.api.safetech.appliance.domain.model.entity.ApplianceTechnical;
import com.api.safetech.appliance.domain.model.entity.ApplianceTechnicalFK;
import com.api.safetech.appliance.domain.persistence.ApplianceRepository;
import com.api.safetech.appliance.domain.persistence.ApplianceTechnicalRepository;
import com.api.safetech.appliance.domain.service.ApplianceService;
import com.api.safetech.appliance.mapping.ApplianceMapper;
import com.api.safetech.appliance.resource.ApplianceResource;
import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.technical.domain.model.entity.Schedule;
import com.api.safetech.technical.domain.model.entity.Technical;
import com.api.safetech.technical.domain.model.entity.TechnicalSchedule;
import com.api.safetech.technical.domain.model.entity.TechnicalScheduleFK;
import com.api.safetech.technical.domain.persistence.ScheduleRepository;
import com.api.safetech.technical.domain.persistence.TechnicalScheduleRepository;
import com.api.safetech.technical.domain.service.ScheduleService;
import com.api.safetech.technical.domain.service.TechnicalService;
import com.api.safetech.technical.mapping.ScheduleMapper;
import com.api.safetech.technical.mapping.TechnicalMapper;
import com.api.safetech.technical.resource.CreateTechnicalResource;
import com.api.safetech.technical.resource.ScheduleResource;
import com.api.safetech.technical.resource.TechnicalResource;
import com.api.safetech.technical.resource.UpdateTechnicalResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Technical")
@RestController
@RequestMapping("/api/v1/technicals")
@CrossOrigin
public class TechnicalController {

    @Autowired
    private TechnicalService technicalService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private TechnicalScheduleRepository technicalScheduleRepository;

    @Autowired
    private ApplianceRepository applianceRepository;

    @Autowired
    private ApplianceTechnicalRepository applianceTechnicalRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private TechnicalMapper mapper;

    @Autowired
    private ApplianceMapper applianceMapper;



    @Operation(summary = "Get Technicals", description = "Get All Technicals")
    @GetMapping
    public List<TechnicalResource> getAllTechnicals()
    {
        return mapper.toResource(technicalService.getAll());
    }

    @Operation(summary = "Get Technicals by Id", description = "Get Technicals by Id")
    @GetMapping("{technicalId}")
    public TechnicalResource getById(@PathVariable Long technicalId)
    {
        return mapper.toResource(technicalService.getById(technicalId));
    }

    @Operation(summary = "Create Technical", description = "Create Technical")
    @PostMapping
    public TechnicalResource createTechnical(@RequestBody CreateTechnicalResource request)
    {
        return mapper.toResource(technicalService.create(mapper.toModel(request)));
    }

    @Operation(summary = "Update Technical", description = "Update Technical by Id")
    @PutMapping("{technicalId}")
    public TechnicalResource updateTechnical(@PathVariable Long technicalId, @RequestBody UpdateTechnicalResource request)
    {
        return mapper.toResource(technicalService.update(technicalId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete technical", description = "Delete technical by Id")
    @DeleteMapping("{technicalId}")
    public ResponseEntity<?> deleteTechnical(@PathVariable Long technicalId)
    {
        return technicalService.delete(technicalId);
    }

    @Operation(summary = "Get Technicals by Email", description = "Get Technicals by Email")
    @GetMapping("email/{technicalEmail}")
    public TechnicalResource getByEmail(@PathVariable String technicalEmail)
    {
        return mapper.toResource(technicalService.getByEmail(technicalEmail));
    }

    @Operation(summary = "Get Technicals by First Name", description = "Get Technicals by First Name")
    @GetMapping("firstName/{firstName}")
    public List<TechnicalResource> getByFirstName(@PathVariable String firstName)
    {
        return mapper.toResource(technicalService.getByFirstName(firstName));
    }

    @Operation(summary = "Get Technicals by Last Name", description = "Get Technicals by Last Name")
    @GetMapping("lastName/{lastName}")
    public List<TechnicalResource> getByLastName(@PathVariable String lastName)
    {
        return mapper.toResource(technicalService.getByLastName(lastName));
    }

    //SHCEDULE - TECHNICAL===================================================>
    @Operation(summary = "Get Technicals by Id", description = "Get Technical by Id")
    @GetMapping("{technicalId}/schedules")
    public List<ScheduleResource> getSchedulesByTechnicalId(@PathVariable Long technicalId)
    {
        return scheduleMapper.toResource(scheduleRepository.findByTechnicalId(technicalId));
    }

    @Operation(summary = "Create schedule by Technical", description = "Create schedule by Technical")
    @PostMapping("{scheduleId}/{technicalId}")
    public TechnicalSchedule createSchedule(@PathVariable Long scheduleId, @PathVariable Long technicalId)
    {
        try {
            Technical technical = technicalService.getById(technicalId);
            Schedule schedule = scheduleService.getById(scheduleId);

            if (schedule == null || technical == null) {
                throw new ResourceNotFoundException("Schedule or technical not found");
            }
            TechnicalScheduleFK newFK = new TechnicalScheduleFK(technicalId, scheduleId);
            TechnicalSchedule technicalSchedule = new TechnicalSchedule(newFK, technical, schedule);
            technicalScheduleRepository.save(technicalSchedule);
            return technicalSchedule;
        }catch (Exception e) {
            throw new ResourceNotFoundException("Schedule or technical not found");
        }
    }

    //APPLIANCE - TECHNICAL===================================================>
    @Operation(summary = "Get Appliances by Id From Technical", description = "Get Appliances by Id From Technical")
    @GetMapping("/appliances/{technicalId}")
    public List<ApplianceResource> getAppliancesByTechnicalId(@PathVariable Long technicalId)
    {
        return applianceMapper.toResource(applianceRepository.findByTechnicalIdFromAppliances(technicalId));
    }

    @Operation(summary = "Create appliance by Technical", description = "Create appliance by Technical")
    @PostMapping("/appliance/{technicalId}/{applianceId}")
    public ApplianceTechnical createAppliance(@PathVariable Long applianceId, @PathVariable Long technicalId)
    {
        try {
            Technical technical = technicalService.getById(technicalId);
            Appliance appliance = applianceService.getById(applianceId);

            if (appliance == null || technical == null) {
                throw new ResourceNotFoundException("Appliance or technical not found");
            }
            ApplianceTechnicalFK newFK = new ApplianceTechnicalFK(technicalId, applianceId);
            ApplianceTechnical applianceTechnical = new ApplianceTechnical(newFK, technical, appliance);
            applianceTechnicalRepository.save(applianceTechnical);
            return applianceTechnical;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Schedule or technical not found");
        }
    }

}
