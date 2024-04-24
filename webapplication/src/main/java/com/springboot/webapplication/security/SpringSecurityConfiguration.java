package com.springboot.webapplication.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

    @SuppressWarnings("deprecation")
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        String string = "admin";
        UserDetails admin = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(string)
                .password("admin")
                .roles("USER,ADMIN")
                .build();

        UserDetails user = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
