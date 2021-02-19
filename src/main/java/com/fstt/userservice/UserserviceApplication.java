package com.fstt.userservice;

import com.fstt.userservice.entities.AppRole;
import com.fstt.userservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args->{
            accountService.saveRole(new AppRole(null,"USER"));
            accountService.saveRole(new AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","user4","admin").forEach(un->{
                accountService.saveUser(un,"1234","1234");
            });
            accountService.addRoleToUser("admin","ADMIN");
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
