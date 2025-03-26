package com.matias.projects.profiles.interfaces;

import java.util.List;

import com.matias.projects.profiles.models.Organization;
import com.matias.projects.profiles.models.User;


public interface OrganizationService {
    public Organization saveOrganization(Organization organization);
    public Organization getOrganizationById(Long id);
    public Organization getOrganizationByName(String name);
    public Organization updateOrganization(Organization organization);
    public void deleteOrganizationById(Long id);
    public List<Organization> getAllOrganizations();
    public List<User> assignUsersToOrganization(Long organizationId, List<User> users);
}
