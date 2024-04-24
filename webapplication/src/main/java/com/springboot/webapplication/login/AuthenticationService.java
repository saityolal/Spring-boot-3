package com.springboot.webapplication.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equals(password) ;
    }

    public String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     return authentication.getName();
    }
}
