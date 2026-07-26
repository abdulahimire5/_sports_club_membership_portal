package com.example.sports_club_membership_portal.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey signingKey;
    private final long expiration;

    public JwtService(@Value("${jwt.secret:change-this-development-secret-key-to-a-secure-value}") String secret,
                      @Value("${jwt.expiration:86400000}") long expiration) {
        this.signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiration = expiration;
    }

    public String generateToken(String email) {
        Date now = new Date();
        return Jwts.builder().subject(email).issuedAt(now).expiration(new Date(now.getTime() + expiration)).signWith(signingKey).compact();
    }

    public String extractEmail(String token) { return Jwts.parser().verifyWith(signingKey).build().parseSignedClaims(token).getPayload().getSubject(); }
    public boolean isValid(String token) { try { extractEmail(token); return true; } catch (RuntimeException ex) { return false; } }
}
