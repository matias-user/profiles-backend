package com.matias.projects.profiles.interfaces;

import java.util.List;

import com.matias.projects.profiles.models.Role;

public interface RoleService {
    public Role saveRole(Role role);
    public Role getRoleById(Long id);
    public Role getRoleByName(String name);
    public Role updateRole(Role role);
    public void deleteRole(Long id);
    public List<Role> getAllRoles();
    
}
