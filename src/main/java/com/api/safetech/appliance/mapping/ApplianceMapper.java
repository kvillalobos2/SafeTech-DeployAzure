package com.api.safetech.appliance.mapping;

import com.api.safetech.appliance.resource.ApplianceResource;
import com.api.safetech.shared.mapping.EnhancedModelMapper;
import com.api.safetech.appliance.domain.model.entity.Appliance;
import com.api.safetech.appliance.resource.CreateApplianceResource;
import com.api.safetech.appliance.resource.UpdateApplianceResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
public class ApplianceMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public ApplianceResource toResource(Appliance model){
        return mapper.map(model, ApplianceResource.class);
    }

    public List<ApplianceResource> toResource(List<Appliance>model){
        return mapper.mapList(model, ApplianceResource.class);
    }

    public Appliance toModel(CreateApplianceResource resource){
        return mapper.map(resource, Appliance.class);
    }

    public Appliance toModel(UpdateApplianceResource resource){
        return mapper.map(resource, Appliance.class);
    }

}
