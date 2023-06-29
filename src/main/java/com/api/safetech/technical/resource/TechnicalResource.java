package com.api.safetech.technical.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class TechnicalResource {

    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Date birthday;
    private String aboutMe;
}
