package com.api.safetech.publication.domain.service;

import com.api.safetech.publication.domain.model.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface CommentService {
    List<Comment> getAll();
    Comment getById(Long commentId);
    Comment create(Comment comment, Long publicationId, Long userId);
    Comment update(Long commentId, Comment request);
    ResponseEntity<?> delete(Long commentId);
    List<Comment> getByPublicationId(Long publicationId);
    List<Comment> getByUserId(Long userId);
}
