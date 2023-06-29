package com.api.safetech.publication.domain.service;

import com.api.safetech.publication.domain.model.entity.Publication;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicationService {
    List<Publication> getAll();
    Publication getById(Long publicationId);
    Publication create(Publication publication, Long technicalId);
    Publication update(Long publicationId, Publication request);
    ResponseEntity<?> delete(Long publicationId);
    List<Publication> getByTechnicalId(Long technicalId);


}
