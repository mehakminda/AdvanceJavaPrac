package com.learning.telusko.springsecurity03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        //we are telling which security filters to be used
        //overriding the default ones

        http.csrf(customizer -> customizer.disable()); //disable csrf
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        // enabling security for all http requests.

        //we have to provide a form
        http.httpBasic(Customizer.withDefaults());

        //make every request stateless
       http.sessionManagement(session -> session.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
        )); //new session id for every request

        


        return http.build();
    }
    //now for post we need not pass csrf because every request is new.
}

/**
 * The @EnableWebSecurity annotation enables Spring Security's web security support and allows you to customize the HTTP security configuration for your application.
 * By using @EnableWebSecurity, you're telling Spring to:
 * Disable default auto-configuration
 * Use your custom SecurityFilterChain bean instead
 * Apply your custom security rules (CSRF disabled, require authentication, stateless sessions, etc.)
 *
 * Without @EnableWebSecurity, your custom security configuration wouldn't be applied. Spring would use its default security setup instead.
 *
 * What it does:
 * Activates Spring Security: It tells Spring to apply security filters to your web application
 * Enables method-level configuration: Allows you to define security rules using @Bean methods (like your securityFilterChain method)
 * Registers security filters: Automatically registers the necessary security filter chain to intercept and process HTTP requests
 *
 */