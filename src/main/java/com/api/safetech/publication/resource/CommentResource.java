package com.api.safetech.publication.resource;
import com.api.safetech.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResource {
    private Long id;
    private String comment;
    private PublicationResource publication;
    private UserResource user;
}
