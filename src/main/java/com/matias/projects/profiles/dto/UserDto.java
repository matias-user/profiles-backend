package com.matias.projects.profiles.dto;

import java.util.List;

import com.matias.projects.profiles.models.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private Integer phoneNumber;
    private List<Role> roles;
    private Boolean disable;
    private Boolean locked;

}
