package com.navisharma.SecurityProject2.service;

import com.navisharma.SecurityProject2.entity.Users;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * This class acts as a bridge between our database Users object
 * and Spring Security's UserDetails object.
 *
 * Our database contains Users:
 *      name + password
 *
 * But Spring Security expects a UserDetails object.
 *
 * Therefore, userPrincipal implements UserDetails and provides
 * the information Spring Security needs for authentication.
 */

public class userPrincipal implements UserDetails
{

    private Users user ;

    public userPrincipal(Users user)   // Constructor receives the Users object that was fetched from the database.
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
}
