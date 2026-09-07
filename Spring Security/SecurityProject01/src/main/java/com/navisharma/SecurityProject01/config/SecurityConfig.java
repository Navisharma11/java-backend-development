package com.navisharma.SecurityProject01.config;

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

@Configuration
@EnableWebSecurity  // Enables Spring Security's integration with Spring MVC/web applications.
public class SecurityConfig  //Your SecurityConfig then customizes how Spring Security should protect your application
{
    @Bean // Handover this entire default security filter chain to my spring
    public SecurityFilterChain securityFiltersChain(HttpSecurity http) //For disturbing the predefined class or filters that are using behind the scene   //HttpSecurity is an object provided by Spring Security that you use to configure web security.
    {
        http.csrf(customizer->customizer.disable()); // Now csrf token will not be generated
//        http.formLogin(Customizer.withDefaults());  //Now the form is available if you not want form comment it
        http.httpBasic(Customizer.withDefaults());   //That means i am enabling access to my application from the postman tool also like any other resource also they can access not onlu from the browser
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  //Here we are making our application stateless so that every request is consider as a new request doesn't matter whether there is a same user or different user

        return http.build();
    }


    @Bean
    public UserDetailsService userDetails()  // Behind the scene the interface UserDetailsService is being used which is taking the username and password from the application.properties and doing the authentication and I want to disturb that for which i am creating the instance of that
    {
        // UserDetails = represents the information of one user
        // username, password and roles are stored inside this object

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Vishal")   // Username of the user
                .password("Telusko1")  // Password of the user
                .roles("USER")          // Role assigned to the user
                .build();                // // Finally creates the UserDetails object

        // Creating another user
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("Rohan")
                .password("Telusko2")
                .roles("ADMIN")
                .build();


        // InMemoryUserDetailsManager is an implementation of UserDetailsService
        // It stores these users in memory.
        //
        // Constructor accepts multiple UserDetails objects because
        // it uses varargs (...).
        //
        // So both 'user' and 'admin' are registered with Spring Security.
        return new InMemoryUserDetailsManager(user,admin);     //It is var args costructor parameter so you can add multiple users   //This InMemoryUserDetailsManager is a implementation class of UserDetailsService Interface
    }


}
