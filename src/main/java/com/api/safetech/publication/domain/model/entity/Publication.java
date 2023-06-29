package com.api.safetech.publication.domain.model.entity;

import com.api.safetech.shared.domain.model.AuditModel;
import com.api.safetech.technical.domain.model.entity.Technical;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name="publications")
public class Publication extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    @NotBlank
    private String urlImage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technical_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Technical technical;

}
