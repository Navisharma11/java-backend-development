package com.navisharma.SecurityProject3.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenService
{
    private String secretKey;

    // Stores the Base64-encoded secret key used for signing and verifying JWTs.

    public JwtTokenService()
    {
        // Spring calls this constructor when it creates the JwtTokenService bean.
        // A secret key is generated and stored when the application starts.
        this.secretKey = getTheSecretKey();
    }

    private String getTheSecretKey()
    {
        try
        {
            // Creates a KeyGenerator for generating an HMAC-SHA256 secret key.
            KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");

            // Generates a secure secret key.
            SecretKey secret = key.generateKey();

            // Converts the key's bytes into a Base64 String
            // so that the key can be stored as a String.
            return Base64.getEncoder()
                    .encodeToString(secret.getEncoded());
        }
        catch(Exception e)
        {
            // If key generation fails, stop the application
            // because JWT signing cannot work without a key.
            throw new RuntimeException("Error in generating key", e);
        }
    }

    public String generateToken(String name)
    {
        // Creates a map for storing additional claims in the JWT.
        Map<String, Object> claims = new HashMap<>();

        // Creates and signs the JWT.
        return Jwts.builder()

                // Adds the custom claims to the JWT payload.
                .claims(claims)

                // Stores the username as the subject of the JWT.
                .subject(name)

                // Stores the time when the JWT was created.
                .issuedAt(new Date(System.currentTimeMillis()))

                // Sets the expiration time.
                // 18,000,000 milliseconds = 5 hours.
                .expiration(
                        new Date(System.currentTimeMillis() + 18000000)
                )

                // Signs the JWT using our secret key.
                // The algorithm is determined from the key.
                .signWith(getKey())

                // Converts the JWT into its final String form.
                .compact();
    }

    private SecretKey getKey()
    {
        // Converts the Base64-encoded secret key back into bytes.
        byte[] b = Decoders.BASE64.decode(secretKey);

        // Converts the bytes into a SecretKey suitable for HMAC signing.
        return Keys.hmacShaKeyFor(b);
    }

    public String extractUserName(String token)
    {
        // Extracts the username stored in the JWT's "sub" (subject) claim.
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(
            String token,
            Function<Claims, T> claimResolver)
    {
        // Extracts all claims from the JWT.
        final Claims claims = extractAllClaims(token);

        // Gets the particular claim requested by claimResolver.
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        // Creates a JWT parser and tells it which key should be used
        // to verify the JWT signature.
        return Jwts.parser()
                .verifyWith(getKey())
                .build()

                // Parses and verifies the signed JWT.
                .parseSignedClaims(token)

                // Gets the JWT payload/claims.
                .getPayload();
    }

    public boolean validateToken(
            String token,
            UserDetails userDetails)
    {
        // Extracts the username from the JWT.
        final String userName = extractUserName(token);

        // Token is valid only when:
        // 1. Username in JWT matches the logged-in user's username.
        // 2. JWT has not expired.
        return userName.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token)
    {
        // Checks whether the expiration time stored in the JWT
        // is before the current time.
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token)
    {
        // Extracts the "exp" (expiration) claim from the JWT.
        return extractClaim(token, Claims::getExpiration);
    }
}