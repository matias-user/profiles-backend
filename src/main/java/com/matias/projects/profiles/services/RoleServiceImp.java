package com.matias.projects.profiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.matias.projects.profiles.interfaces.RoleService;
import com.matias.projects.profiles.models.Role;
import com.matias.projects.profiles.repositories.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        role.setName(role.getName().toLowerCase());
        return roleRepository.save(role);
    }
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElseThrow();
    }

    @Override
    public Role updateRole(Role role) {
        role.setId(0L);
        Role existingRole = roleRepository.findById(role.getId()).orElseThrow();
        existingRole.setId(0L);
        existingRole.setName(role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            roleRepository.delete(role.get());
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
