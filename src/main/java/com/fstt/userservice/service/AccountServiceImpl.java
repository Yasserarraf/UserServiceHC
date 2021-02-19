package com.fstt.userservice.service;

import com.fstt.userservice.dao.AppRoleRepository;
import com.fstt.userservice.dao.AppUserRepository;
import com.fstt.userservice.entities.AppRole;
import com.fstt.userservice.entities.AppUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public AppUser saveUser(String email, String password, String confirmedPassword) {

        AppUser  user = appUserRepository.findByEmail(email);
        if(user!=null) throw new RuntimeException("User already Exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Password not Confirmed");
        AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setActivated(true);
        appUserRepository.save(appUser);
        addRoleToUser(email,"USER");
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }



    @Override
    public void addRoleToUser(String email, String roleName) {
        AppUser appUser = appUserRepository.findByEmail(email);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getRoles().add(appRole);
    }
}
