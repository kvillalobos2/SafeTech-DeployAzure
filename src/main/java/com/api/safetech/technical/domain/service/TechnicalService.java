package com.api.safetech.technical.domain.service;

import com.api.safetech.technical.domain.model.entity.Technical;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TechnicalService {
    List<Technical> getAll();
    Technical getById(Long TechnicalId);
    Technical create(Technical request);
    Technical update(Long technicalId, Technical request);
    ResponseEntity<?> delete(Long technicalId);
    Technical getByEmail(String email);
    List<Technical> getByFirstName(String firstName);
    List<Technical> getByLastName(String lastName);
}
