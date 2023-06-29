package com.api.safetech.technical.domain.persistence;

import com.api.safetech.appliance.domain.model.entity.Appliance;
import com.api.safetech.technical.domain.model.entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
    Technical findByEmail(String email);
    List<Technical> findByFirstName(String firsName);
    List<Technical> findByLastName(String lastName);

    @Query(value = "select * from technical where id in(select b.technical_id From technical_appliance b Where b.appliance_id = :appliance_id)", nativeQuery = true)
    List<Technical> findByApplianceTechnicals(@Param("appliance_id") Long appliance_id);
}
