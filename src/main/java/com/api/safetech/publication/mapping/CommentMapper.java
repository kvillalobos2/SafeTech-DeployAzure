package com.api.safetech.publication.mapping;

import com.api.safetech.publication.domain.model.entity.Comment;
import com.api.safetech.publication.resource.CreateCommentResource;
import com.api.safetech.publication.resource.CommentResource;
import com.api.safetech.publication.resource.UpdateCommentResource;
import com.api.safetech.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    // Object Mapping
    public CommentResource toResource(Comment model)
    {
        return mapper.map(model, CommentResource.class);
    }

    public List<CommentResource> toResource(List<Comment> model)
    {
        return mapper.mapList(model, CommentResource.class);
    }

    public Comment toModel(CreateCommentResource resource)
    {
        return mapper.map(resource, Comment.class);
    }

    public Comment toModel(UpdateCommentResource resource)
    {
        return mapper.map(resource, Comment.class);
    }

}
