package com.navisharma.SecurityProject2.rest;

import com.navisharma.SecurityProject2.entity.Users;
import com.navisharma.SecurityProject2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/get-courseinfo")
    public String getCourseInfo()
    {
        return "Telusko launched DevOps with AWS course from scratch ";
    }
}
