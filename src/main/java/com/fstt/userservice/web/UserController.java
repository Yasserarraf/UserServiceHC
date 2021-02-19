package com.fstt.userservice.web;

import com.fstt.userservice.entities.AppUser;
import com.fstt.userservice.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
        return accountService.saveUser(
                userForm.getEmail(),userForm.getPassword(), userForm.getConfirmedPassword());
    }
}
@Data
class UserForm{
    private String email;
    private String password;
    private String confirmedPassword;
}
