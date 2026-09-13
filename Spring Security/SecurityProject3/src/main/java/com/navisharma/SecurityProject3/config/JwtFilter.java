package com.navisharma.SecurityProject3.config;

import com.navisharma.SecurityProject3.service.JwtTokenService;
import com.navisharma.SecurityProject3.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenService service;

    @Autowired
    private MyUserDetailsService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
       String authHeader = request.getHeader("Authorization");
       String token = null;
       String name = null;
       if(authHeader!=null && authHeader.startsWith("Bearer "))  //Bearer will also travel that is the name of the header
       {
           token = authHeader.substring(7); //We are ignoring this Bearer
           name = service.extractUserName(token);
       }
        // Continue only if a username was successfully extracted from the JWT
        // and the request is not already authenticated.
       if(name!=null && SecurityContextHolder.getContext().getAuthentication()==null)
       {
           // Load the user's details from the database using the username
           // extracted from the JWT.
           UserDetails userDetails = userService.loadUserByUsername(name);

           // Validate the JWT by checking the username and token expiration.
          Boolean status = service.validateToken(token,userDetails);

           // Continue with authentication only if the JWT is valid.
          if(status)
          {
              // Create an Authentication object containing the user's details
              // and their authorities/roles. Password is null because the user
              // has already been authenticated using the JWT.
              UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

              // Attach details of the current HTTP request to the Authentication object.
              authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

              // Print the authentication object for debugging purposes.
              System.out.println("autho token :" + authToken);

              // Store the authenticated user in Spring Security's SecurityContext.
              // This tells Spring Security that the current request is authenticated.
              SecurityContextHolder.getContext().setAuthentication(authToken);
          }
       }
        // Pass the request to the next filter in the Spring Security filter chain.
       filterChain.doFilter(request,response);
    }
}





// Complete Jwt Flow
//
//
//                    LOGIN
//                      │
//                      ↓
//                  POST /login
//                      │
//                      ↓
//              Username + Password
//                      │
//                      ↓
//              AuthenticationManager
//                      │
//                      ↓
//             AuthenticationProvider
//                      │
//                      ↓
//              UserDetailsService
//                      │
//                      ↓
//                   Database
//                      │
//                      ↓
//             Password Verification
//                      │
//              ┌───────┴───────┐
//              │               │
//            FAIL            SUCCESS
//              │               │
//              ↓               ↓
//           Reject          generateToken()
//                              │
//                              ↓
//                          Create JWT
//                              │
//                              ↓
//                          Return JWT
//                              │
//                              ↓
//                       Client stores it
//                              │
//             ════════════════════════════════════════════
//                        NEXT REQUEST
//             ════════════════════════════════════════════
//                              │
//                              ↓
//                     GET /get-courseinfo
//                              │
//                              ↓
//                   Authorization: Bearer JWT
//                              │
//                              ↓
//                           JwtFilter
//                              │
//                              ↓
//                      Extract JWT token
//                              │
//                              ↓
//                       extractUserName()
//                              │
//                              ↓
//                           "Vishal"
//                              │
//                              ↓
//                      loadUserByUsername()
//                              │
//                              ↓
//                         UserDetails
//                              │
//                              ↓
//                        validateToken()
//                              │
//                    ┌─────────┴─────────┐
//                    │                   │
//                  INVALID             VALID
//                    │                   │
//                    ↓                   ↓
//                 Reject          Create Authentication
//                                        │
//                                        ↓
//                              SecurityContextHolder
//                                        │
//                                        ↓
//                                  Authentication
//                                        │
//                                        ↓
//                               filterChain.doFilter()
//                                        │
//                                        ↓
//                                    Controller
//                                        │
//                                        ↓
//                                     Response
