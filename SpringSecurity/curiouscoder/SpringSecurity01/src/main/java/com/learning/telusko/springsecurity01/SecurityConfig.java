package com.learning.telusko.springsecurity01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // beans will be created
@EnableWebSecurity // we will give our own security implementation
public class SecurityConfig {

    @Bean
    public SecurityFilterChain basicAuth(HttpSecurity http){
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth
                                //.anyRequest().permitAll())
                                .requestMatchers("/hello").permitAll()
                                .requestMatchers("/users/encodePassword").permitAll()
                                .requestMatchers("/users/authenticate").permitAll()
                                .anyRequest().authenticated())
                //.httpBasic(Customizer.withDefaults()); for basic authentication
                .addFilterBefore()
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
/**
 * Adding basic auth:
 *
 *  http
 *                 .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
 *                 .httpBasic(Customizer.withDefaults());
 *
 *
 *    echo "" | base64 --decode
 */


/**
 * Do we also disable csrf in prod?
 *  No, you should not disable CSRF in production if your application uses session-based authentication
 *  (cookies). However, yes, you can safely disable CSRF in production if your application is a
 *  stateless REST API using JWTs stored in local storage, which appears to be what you are building.
 *
 *  Here is a direct comparison to help you decide based on your architecture:
 *
 * Authentication Method:
 *
 * 1.session/cookie based(stateful):
 *  - are CSRF vulnerable
 *  - hence do not disable CSRF in prod
 *  - why: Browsers automatically append cookies to every request.
 *         Attackers can exploit this via malicious links.
 *
 * 2. JWT in auth header(stateless):
 *  - are not CSRF vulnerable
 *  - CSRF can be disabled in prod
 *  - why? Custom HTTP headers (like Authorization: Bearer <token>) are not automatically sent by browsers.
 */