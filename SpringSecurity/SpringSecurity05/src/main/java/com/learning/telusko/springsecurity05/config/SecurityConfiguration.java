package com.learning.telusko.springsecurity05.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;
    //UserDetailsService is an interface so we need to create an implementation class for it.

    @Bean
    public AuthenticationProvider authProvider(){


        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;

    }

    //we can have multiple auth provider in an application


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        http.csrf(customizer->customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
/*
    @Bean
    public UserDetailsService userDetailsService() {


    }*/ //this works with static values


}

/***
 * we want custom user and hardcode from application properties
 *
 * in-memory user and then users from database
 *
 * here we will use from database here
 *
 */

/**
 * by default spring uses UserDetailsService class, which will look for username and password in application properties
 *
 * BUt I want to define my own userDetailsService
 *
 * observe that the user mentioned in application properties should not work
 *
 */

/**
 * By default spring provides a default authentication provider.
 * But we want to create one of our own authentication provider.
 */

/**Here we are storing our password in db in plain text.
 * in next projects we will encrypt our passwords as well.
 */