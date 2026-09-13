package com.navisharma.SecurityProject3.rest;

import com.navisharma.SecurityProject3.entity.Users;
import com.navisharma.SecurityProject3.service.JwtTokenService;
import com.navisharma.SecurityProject3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeluskoController
{
    /*
     * UserService contains the business logic for working with users.
     *
     * Spring automatically injects the UserService object here.
     */


    @Autowired
    private UserService service;


    @Autowired
    private AuthenticationManager authManager;


    @Autowired
    private JwtTokenService jwtservice;


    /*
     * BCryptPasswordEncoder is used to hash/encrypt the user's password
     * before storing it in the database.
     *
     * The number 12 is the strength/cost factor used by BCrypt.
     *
     * We should NEVER store the user's original/plain-text password
     * directly in the database.
     */
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);  //Spring by default supports this BCryptPasswordEncoder Algorithm so no need to add any dependecy or library

    @PostMapping("/add-user")
    public Users registerNewUser(@RequestBody Users user)
    {
        /*
         * Get the plain-text password entered by the user
         * and encode/hash it using BCrypt.
         *
         * Example:
         *
         * "Telusko1"
         *      ↓
         * BCrypt
         *      ↓
         * "$2a$12$...."
         */
        String encoded = bcrypt.encode(user.getPassword());

        /*
         * Replace the plain-text password with the BCrypt
         * encoded password before saving the user.
         */
        user.setPassword(encoded);

        /*
         * Send the user to UserService.
         *
         * UserService will handle the next step, such as
         * saving the user into the database.
         */
        return service.register(user);
    }


    @PostMapping("/login")
    public String loginUser(@RequestBody Users user)
    {
        // Creates an Authentication object containing the username and password
        // provided by the user and passes it to AuthenticationManager for verification.
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));

        // Checks whether Spring Security successfully authenticated the user.
        if(authentication.isAuthenticated())
        {
            String jwt = jwtservice.generateToken(user.getName());
            System.out.println(jwt);
            return jwt;
        }
        else
        {
            return "Invalid credentials";
        }
    }


    @GetMapping("/get-courseinfo")
    public String getCourseInfo()
    {
        return "Telusko launched DevOps with AWS course from scratch ";
    }
}
