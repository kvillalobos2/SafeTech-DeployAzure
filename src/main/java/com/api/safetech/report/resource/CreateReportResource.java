package com.api.safetech.report.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateReportResource {
    @NotNull
    @NotBlank
    private String applianceType;

    @NotNull
    @NotBlank
    private String applianceModel;

    @NotNull
    @NotBlank
    private String applianceBrand;

    @NotNull
    @NotBlank
    private String applianceDiagnostic;

    @NotNull
    @NotBlank
    private String reparationDetails;
}
