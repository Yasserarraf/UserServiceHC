package com.fstt.userservice.service;

import com.fstt.userservice.entities.AppRole;
import com.fstt.userservice.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String email,String password,String confirmedPassword);
    public AppRole saveRole(AppRole role);
    public AppUser loadUserByEmail(String email);
    public void addRoleToUser(String email,String roleName);
}
