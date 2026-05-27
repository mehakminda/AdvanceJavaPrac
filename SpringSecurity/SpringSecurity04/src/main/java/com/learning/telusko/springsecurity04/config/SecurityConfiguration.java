package com.learning.telusko.springsecurity04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        http.csrf(customizer->customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.withDefaultPasswordEncoder().username("jalaj").password("1234").roles("admin").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("renu").password("1234").roles("admin","user").build();
        UserDetails user3 = User.withDefaultPasswordEncoder().username("manish").password("1234").roles("user").build();

        return new InMemoryUserDetailsManager(List.of(user1, user2,user3));

    }

}

/**
 * we are getting popup and not form, coz we are saying we want http basic authentication and not form
 *
 * logout is not working because we have not added logout filter
 */


/***
 * we want custom user and hardcode from application properties
 *
 * in-memory user and then users from database
 *
 * here we will use in-memory user
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