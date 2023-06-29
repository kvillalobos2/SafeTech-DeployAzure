package com.api.safetech.appointment.domain.model.entity;

import com.api.safetech.appliance.domain.model.entity.Appliance;
import com.api.safetech.shared.domain.model.AuditModel;
import com.api.safetech.technical.domain.model.entity.Technical;
import com.api.safetech.user.domain.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "appointment")
public class Appointment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String problemDescription;

    @NotNull
    private Date scheduledAt;

    @NotNull
    @NotBlank
    private String address;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technical_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Technical technical;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appliance_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Appliance appliance;



}
