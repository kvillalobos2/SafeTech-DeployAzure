package com.api.safetech.publication.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResource {
    private Long id;
    private String tag;
    private PublicationResource publication;
}
