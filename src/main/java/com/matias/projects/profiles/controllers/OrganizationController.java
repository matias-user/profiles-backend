package com.matias.projects.profiles.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.projects.profiles.interfaces.OrganizationService;
import com.matias.projects.profiles.models.Organization;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {
    
    private OrganizationService service;

    public OrganizationController(OrganizationService organizationService) {
        this.service = organizationService;
    }

    @GetMapping
    public List<Organization> getOrganizations(){
        return service.getAllOrganizations();
    }

    @GetMapping("{id}")
    public Organization getOrganizationById( @PathVariable Long id){
        return service.getOrganizationById(id);
    }
    @DeleteMapping("{id}")
    public void deleteOrganizationById(@PathVariable Long id){
        service.deleteOrganizationById(id);
    }
    @GetMapping("/name/{name}")
    public Organization getOrganizationByName(@PathVariable String name){
        return service.getOrganizationByName(name);
    }
    @PostMapping
    public Organization saveOrganization(@RequestBody Organization organization){
        return service.saveOrganization(organization);
    }
}
