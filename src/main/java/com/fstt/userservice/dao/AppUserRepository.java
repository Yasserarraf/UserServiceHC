package com.fstt.userservice.dao;

import com.fstt.userservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByEmail(String email);
}
