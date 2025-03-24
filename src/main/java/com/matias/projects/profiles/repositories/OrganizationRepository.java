package com.matias.projects.profiles.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matias.projects.profiles.models.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    Optional<Organization> findByName(String name);
}
