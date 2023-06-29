package com.api.safetech.technical.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateScheduleResource {

    private Long id;

    @NotNull
    @NotBlank
    private String time;
}
