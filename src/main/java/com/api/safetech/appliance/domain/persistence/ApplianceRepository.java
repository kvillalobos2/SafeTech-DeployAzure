package com.api.safetech.appliance.domain.persistence;


import com.api.safetech.appliance.domain.model.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    @Query(value = "select * from appliance where id in(select b.appliance_id From technical_appliance b Where b.technical_id = :technical_id)", nativeQuery = true)
    List<Appliance> findByTechnicalIdFromAppliances(@Param("technical_id") Long technical_id);

    List<Appliance>findByName(String name);
}
