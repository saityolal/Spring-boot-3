package com.springboot.webapplication.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails admin = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("admin")
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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()).formLogin(
                        form -> form
                                // .loginPage("/welcome")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()

        ).logout(logout -> logout.permitAll());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        // * all the request that coming must be authenticated

        return http.build();
    }
    

}
