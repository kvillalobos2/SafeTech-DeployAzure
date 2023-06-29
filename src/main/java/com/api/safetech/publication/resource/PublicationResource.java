package com.api.safetech.publication.resource;

import com.api.safetech.technical.resource.TechnicalResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicationResource {

    private Long id;
    private String title;
    private String description;
    private String urlImage;
    private TechnicalResource technical;
}
