package com.api.safetech.publication.service;

import com.api.safetech.publication.domain.model.entity.Publication;
import com.api.safetech.publication.domain.persistence.PublicationRepository;
import com.api.safetech.publication.domain.service.PublicationService;
import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.technical.domain.model.entity.Technical;
import com.api.safetech.technical.domain.persistence.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final static String ENTITY = "Publication";

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getById(Long publicationId) {
        return publicationRepository.findById(publicationId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public Publication create(Publication publication, Long technicalId) {
        Technical technical = technicalRepository.findById(technicalId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id" + technicalId));
        publication.setTechnical(technical);
        return publicationRepository.save(publication);
    }

    @Override
    public Publication update(Long publicationId, Publication request) {
        return publicationRepository.findById(publicationId).map(publication ->
                publicationRepository.save(publication
                        .withTitle(request.getTitle())
                        .withDescription(request.getDescription())
                        .withUrlImage(request.getUrlImage())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public ResponseEntity<?> delete(Long publicationId) {
        return publicationRepository.findById(publicationId).map(publication -> {
            publicationRepository.delete(publication);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public List<Publication> getByTechnicalId(Long technicalId) {
        return publicationRepository.findByTechnicalId(technicalId);
    }
}
