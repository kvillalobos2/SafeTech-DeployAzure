package com.api.safetech.publication.domain.service;

import com.api.safetech.publication.domain.model.entity.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface TagService {
    List<Tag> getAll();
    Tag getById(Long tagId);
    Tag create(Tag tag, Long publicationId);
    Tag update(Long tagId, Tag request);
    ResponseEntity<?> delete(Long tagId);
    List<Tag> getByPublicationId(Long publicationId);
}
