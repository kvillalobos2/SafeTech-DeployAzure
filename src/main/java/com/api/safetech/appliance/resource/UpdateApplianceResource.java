package com.api.safetech.appliance.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateApplianceResource {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Float cost;
}
