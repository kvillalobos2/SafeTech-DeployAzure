package com.api.safetech.technical.domain.model.entity;

import com.api.safetech.appliance.domain.model.entity.ApplianceTechnical;
import com.api.safetech.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "technical", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}),
                                                @UniqueConstraint(columnNames = {"dni"})

})
public class Technical extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8, max = 20)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String phone;

    @NotNull
    private Date birthday;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String aboutMe;

    @OneToMany(mappedBy = "technical")
    private List<TechnicalSchedule> technicalSchedules;

    @OneToMany(mappedBy = "technical")
    private List<ApplianceTechnical> applianceTechnicals;

    public Technical(Long id, String firstName, String lastName, String dni, String email, String password, String address, String phone, Date birthday, String aboutMe) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.aboutMe = aboutMe;
    }

}
