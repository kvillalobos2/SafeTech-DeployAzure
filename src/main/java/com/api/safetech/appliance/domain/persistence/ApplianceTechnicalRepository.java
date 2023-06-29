package com.api.safetech.appliance.domain.persistence;

import com.api.safetech.appliance.domain.model.entity.ApplianceTechnical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceTechnicalRepository extends JpaRepository<ApplianceTechnical, Long> {}
