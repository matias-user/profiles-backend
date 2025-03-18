package com.matias.projects.profiles.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.projects.profiles.interfaces.RoleService;
import com.matias.projects.profiles.models.Role;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role saveRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }
    @GetMapping("/name/{name}")
    public Role getRoleByName(@PathVariable String name) {
        return roleService.getRoleByName(name.toLowerCase());
    }
    @PutMapping
    public Role updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }
    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}
