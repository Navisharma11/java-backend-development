package com.navisharma.SecurityProject2.service;

import com.navisharma.SecurityProject2.entity.Users;
import com.navisharma.SecurityProject2.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
   private IUserRepo repo;


    /*
     * Spring Security calls this method when it needs to find
     * a user during authentication.
     *
     * The "username" parameter is the username entered by the user
     * during login.
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repo.findByName(username);
        if(users==null)
        {
            throw new UsernameNotFoundException("user not found 404");
        }

        /*
         * The database returns a Users object, but Spring Security
         * expects a UserDetails object.
         *
         * userPrincipal implements UserDetails, so we convert/wrap
         * our Users object inside userPrincipal.
         *
         * Flow:
         *
         * Database
         *    ↓
         * Users object
         *    ↓
         * userPrincipal
         *    ↓
         * UserDetails
         *    ↓
         * Spring Security
         */

        return new userPrincipal(users);
    }
}
