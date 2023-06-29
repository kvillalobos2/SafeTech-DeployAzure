package com.api.safetech.appliance.mapping;

import com.api.safetech.appliance.mapping.ApplianceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("applianceMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ApplianceMapper applianceMapper(){
        return new ApplianceMapper();
    }
}
