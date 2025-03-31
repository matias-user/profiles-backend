package com.matias.projects.profiles.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "app_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer phoneNumber;
    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn( name = "user_id" ),
        inverseJoinColumns = @JoinColumn( name = "role_id" )
    )
    private List<Role> roles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    @JsonIgnore 
    private Organization organization;
    private Boolean disable;
    private Boolean locked;

}
