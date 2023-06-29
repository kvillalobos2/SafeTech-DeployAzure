package com.api.safetech.publication.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateTagResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String tag;
}
