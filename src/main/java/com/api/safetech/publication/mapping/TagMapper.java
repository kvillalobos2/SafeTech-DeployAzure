package com.api.safetech.publication.mapping;

import com.api.safetech.publication.domain.model.entity.Tag;

import com.api.safetech.publication.resource.CreateTagResource;
import com.api.safetech.publication.resource.TagResource;
import com.api.safetech.publication.resource.UpdateTagResource;
import com.api.safetech.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public TagResource toResource(Tag model) { return mapper.map(model, TagResource.class);
    }
    public List<TagResource> toResource(List<Tag> model)
    {
        return mapper.mapList(model, TagResource.class);
    }

    public Tag toModel(CreateTagResource resource)
    {
        return mapper.map(resource, Tag.class);
    }

    public Tag toModel(UpdateTagResource resource)
    {
        return mapper.map(resource, Tag.class);
    }

}

