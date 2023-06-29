package com.api.safetech.appliance.api;


import com.api.safetech.appliance.domain.persistence.ApplianceRepository;
import com.api.safetech.appliance.domain.service.ApplianceService;
import com.api.safetech.appliance.mapping.ApplianceMapper;
import com.api.safetech.appliance.resource.ApplianceResource;
import com.api.safetech.appliance.resource.CreateApplianceResource;
import com.api.safetech.appliance.resource.UpdateApplianceResource;
import com.api.safetech.technical.domain.persistence.TechnicalRepository;
import com.api.safetech.technical.domain.service.TechnicalService;
import com.api.safetech.technical.mapping.TechnicalMapper;
import com.api.safetech.technical.resource.TechnicalResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appliance")
@RestController
@RequestMapping("api/v1/appliances")
@CrossOrigin
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ApplianceMapper applianceMapper;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private TechnicalMapper technicalMapper;

    @Operation(summary = "Get All Appliances", description = "Get All Appliances")
    @GetMapping
    public List<ApplianceResource> getAllAppliance() { return applianceMapper.toResource(applianceService.getAll());}

    @Operation(summary = "Get Appliance by Id", description = "Get Appliance  by Id")
    @GetMapping("{applianceId}")
    public ApplianceResource getApplianceById(@PathVariable Long applianceId){
        return applianceMapper.toResource(applianceService.getById(applianceId));
    }

    @Operation(summary = "Get Appliance by Name", description = "Get Appliance by Name")
    @GetMapping("/name/{name}")
    public List<ApplianceResource> getByName(@PathVariable String name){
        return applianceMapper.toResource(applianceService.getByName(name));
    }

    @Operation(summary = "Create New Appliance", description = "Create New Appliance")
    @PostMapping
    public ApplianceResource createAppliance(@RequestBody CreateApplianceResource model){
        return applianceMapper.toResource(applianceService.create(applianceMapper.toModel(model)));
    }
    @Operation(summary = "Update Appliance", description = "Update Appliance")
    @PutMapping("{applianceId}")
    public ApplianceResource updateAppliance(@PathVariable Long applianceId, @RequestBody UpdateApplianceResource model){
        return applianceMapper.toResource(applianceService.update(applianceId, applianceMapper.toModel(model)));
    }
    @Operation(summary = "Delete Appliance", description = "Delete Appliance")
    @DeleteMapping("{applianceId}")
    public void deleteAppliance(@PathVariable Long applianceId){ applianceService.delete(applianceId);}


    //---------------------------------------------------------------------------------------------------------------------
    @Operation(summary = "Get Appliances by Id From Technical", description = "Get Appliances by Id From Technical")
    @GetMapping("technicalId/{applianceId}")
    public List<TechnicalResource> getAppliancesByTechnicalId(@PathVariable Long applianceId)
    {
        return technicalMapper.toResource(technicalRepository.findByApplianceTechnicals(applianceId));
    }

}
