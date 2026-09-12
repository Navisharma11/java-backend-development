package com.navisharma.SecurityProject2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // Enables Spring Security's integration with Spring MVC/web applications.
public class SecurityConfig  //Your SecurityConfig then customizes how Spring Security should protect your application
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean // Handover this entire default security filter chain to my spring
    public SecurityFilterChain securityFiltersChain(HttpSecurity http) //For disturbing the predefined class or filters that are using behind the scene   //HttpSecurity is an object provided by Spring Security that you use to configure web security.
    {
        http.csrf(customizer->customizer.disable()); // Now csrf token will not be generated
//        http.formLogin(Customizer.withDefaults());  //Now the form is available if you not want form comment it


        http.authorizeHttpRequests(authorizeHttp->authorizeHttp
                .requestMatchers("/add-user").permitAll().anyRequest().authenticated());


//        http.authorizeHttpRequests(authorizeHttp -> authorizeHttp
//                        // authorizeHttp is the authorization configuration object
//                        // provided by Spring Security to this lambda.
//
//                        .requestMatchers("/add-user")
//                        // Select the /add-user URL.
//
//                        .permitAll()
//                        // Allow everyone to access /add-user without authentication.
//
//                        .anyRequest()
//                        // Select every other HTTP request that has not been matched above.
//
//                        .authenticated()
//                // Require the user to be authenticated for all those requests.




        http.httpBasic(Customizer.withDefaults());   //That means i am enabling access to my application from the postman tool also like any other resource also they can access not only from the browser
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  //Here we are making our application stateless so that every request is consider as a new request doesn't matter whether there is a same user or different user

        return http.build();
    }


    @Bean
    public AuthenticationProvider authProvider()   // How you want to do the authentication that i want to write here
    {

        /*
         * DaoAuthenticationProvider is responsible for performing
         * username/password authentication.
         *
         * We provide our custom UserDetailsService to it.
         *
         * userDetailsService is actually our MyUserDetailsService,
         * which fetches the user's information from the database.
         *
         * Flow:
         *
         * DaoAuthenticationProvider
         *          ↓
         * UserDetailsService
         *          ↓
         * MyUserDetailsService
         *          ↓
         * IUserRepo
         *          ↓
         * MySQL database
         */
         DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider(userDetailsService);    // It means connecting to database and getting the information means doing authentication using the database part
//         daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        /*
         * Tell DaoAuthenticationProvider which PasswordEncoder
         * should be used to verify the password.
         *
         * We use BCrypt because the passwords stored in our database
         * are BCrypt encoded when the user registers.
         *
         * During login:
         *
         * Password entered by user
         *          ↓
         * BCryptPasswordEncoder
         *          ↓
         * Compare with encoded password from database
         *          ↓
         * Match → Authentication successful
         * No match → Authentication failed
         */
         daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));

         return daoProvider;
    }



//
//    @Bean
//    public UserDetailsService userDetails()  // Behind the scene the interface UserDetailsService is being used which is taking the username and password from the application.properties and doing the authentication and I want to disturb that for which i am creating the instance of that
//    {
//        // UserDetails = represents the information of one user
//        // username, password and roles are stored inside this object
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("Vishal")   // Username of the user
//                .password("Telusko1")  // Password of the user
//                .roles("USER")          // Role assigned to the user
//                .build();                // // Finally creates the UserDetails object
//
//        // Creating another user
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("Rohan")
//                .password("Telusko2")
//                .roles("ADMIN")
//                .build();
//
//
//        // InMemoryUserDetailsManager is an implementation of UserDetailsService
//        // It stores these users in memory.
//        //
//        // Constructor accepts multiple UserDetails objects because
//        // it uses varargs (...).
//        //
//        // So both 'user' and 'admin' are registered with Spring Security.
//        return new InMemoryUserDetailsManager(user,admin);     //It is var args costructor parameter so you can add multiple users   //This InMemoryUserDetailsManager is a implementation class of UserDetailsService Interface
//    }


}
