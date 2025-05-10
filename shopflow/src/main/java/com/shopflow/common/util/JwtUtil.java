package com.shopflow.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private static final SecretKey SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(UserDetails user){
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("rol", user.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public Claims obtainClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return obtainClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername( String token) {
        return obtainClaims(token).getSubject();
    }

    public List<String> extractRoles(String token) {
        List<Map<String, Object>> roles = obtainClaims(token).get("rol", List.class);
        return roles.stream()
                .map(role -> (String) role.get("authority"))
                .collect(Collectors.toList());
    }
}
