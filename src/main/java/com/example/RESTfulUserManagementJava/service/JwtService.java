package com.example.RESTfulUserManagementJava.service;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static String createJWTToken(String email, String name) {
        long durationMillis = 24 * 60 * 60 * 1000; // 86400000 milisegundos = 24 horas
        long currentTimeMillis = System.currentTimeMillis();

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("name", name);

        return Jwts.builder()
                .setSubject(String.valueOf(claims))
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + durationMillis))
                .signWith(key)
                .compact();
    }

    public static boolean validateJWTToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            System.err.println("Invalid token: " + ex.getMessage());
            return false;
        }
    }
}
