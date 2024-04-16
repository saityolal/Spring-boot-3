package com.springboot.webapplication.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equals(password) ;
    }

}
