package com.matias.projects.profiles.dto;

import java.util.List;

import com.matias.projects.profiles.models.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String username;
    private String password;
    private String email;
    private Integer phoneNumber;
    private Boolean locked;
    private Boolean disable;
    private List<Role> roles;

}
