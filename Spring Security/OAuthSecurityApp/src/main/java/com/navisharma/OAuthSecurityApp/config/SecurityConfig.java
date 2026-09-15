package com.navisharma.OAuthSecurityApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        // Protects all requests so that only authenticated users can access them,
        // and enables OAuth2 login (e.g., "Sign in with Google") using Spring Security's default configuration
        http.authorizeHttpRequests(auth-> auth.anyRequest().authenticated()).oauth2Login(Customizer.withDefaults());
        return http.build();
    }

}
