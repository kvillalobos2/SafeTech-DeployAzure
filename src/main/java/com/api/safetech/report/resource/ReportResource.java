package com.api.safetech.report.resource;

import com.api.safetech.user.domain.model.entity.User;
import com.api.safetech.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReportResource {
    private Long id;
    private String applianceType;
    private String applianceModel;
    private String applianceBrand;
    private String applianceDiagnostic;
    private String reparationDetails;
    private UserResource user;
}
