package com.api.safetech.publication.resource;

import com.api.safetech.technical.domain.model.entity.Technical;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePublicationResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    @NotBlank
    private String urlImage;
}
