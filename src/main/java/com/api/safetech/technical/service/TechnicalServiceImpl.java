package com.api.safetech.technical.service;

import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.technical.domain.model.entity.Technical;
import com.api.safetech.technical.domain.persistence.TechnicalRepository;
import com.api.safetech.technical.domain.service.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class TechnicalServiceImpl implements TechnicalService {

    private final static String ENTITY = "Technical";

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Technical> getAll() {
        return technicalRepository.findAll();
    }

    @Override
    public Technical getById(Long technicalId) {
        return technicalRepository.findById(technicalId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, technicalId));
    }

    @Override
    public Technical create(Technical request) {
        return technicalRepository.save(request);
    }

    @Override
    public Technical update(Long technicalId, Technical request) {
        return technicalRepository.findById(technicalId).map(technical ->
                technicalRepository.save(technical.withFirstName(request.getFirstName())
                        .withLastName(request.getLastName())
                        .withDni(request.getDni())
                        .withEmail(request.getEmail())
                        .withPassword(request.getPassword())
                        .withAddress(request.getAddress())
                        .withPhone(request.getPhone())
                        .withBirthday(request.getBirthday())
                        .withAboutMe(request.getAboutMe())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, technicalId));
    }

    @Override
    public ResponseEntity<?> delete(Long technicalId) {
        return technicalRepository.findById(technicalId).map(technical -> {
            technicalRepository.delete(technical);
            return  ResponseEntity.ok().build();
        }).orElseThrow(() ->new ResourceNotFoundException(ENTITY, technicalId));
    }

    @Override
    public Technical getByEmail(String technicalEmail) {
        return technicalRepository.findByEmail(technicalEmail);
    }

    @Override
    public List<Technical> getByFirstName(String firstName) {
        return technicalRepository.findByFirstName(firstName);
    }

    @Override
    public List<Technical> getByLastName(String lastName) {
        return technicalRepository.findByLastName(lastName);
    }
}
