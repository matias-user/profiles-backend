package com.matias.projects.profiles.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matias.projects.profiles.exception.OrganizationNotFoundException;
import com.matias.projects.profiles.interfaces.OrganizationService;
import com.matias.projects.profiles.models.Organization;
import com.matias.projects.profiles.repositories.OrganizationRepository;

@Service
public class OrganizationServiceImp implements OrganizationService{

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImp(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElseThrow( () -> new OrganizationNotFoundException("No se ha encontrado la organización con el id: "+id) );
    }

    @Override
    public Organization getOrganizationByName(String name) {
        return organizationRepository.findByName(name).orElseThrow(() -> new OrganizationNotFoundException("No se ha encontrado la organización con el nombre: "+ name));
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrganization'");
    }

    @Override
    public void deleteOrganizationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrganizationById'");
    }

    @Override
    public List<Organization> getAllOrganizations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOrganizations'");
    }
    
}
