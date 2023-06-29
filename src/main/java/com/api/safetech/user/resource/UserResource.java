package com.api.safetech.user.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
public class UserResource {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Date birthday;
}
