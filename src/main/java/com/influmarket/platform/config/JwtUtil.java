package com.influmarket.platform.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET;
    private final long EXPIRATION_TIME=1000*60*60;
    private Key getSigningkey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    public String extractRole(String token){
        return getClaims(token).get("role",String.class);
    }
    public String generateToken(String email, String role){
        return Jwts.builder()
        .setSubject(email)
        .claim("role",role)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
        .signWith(getSigningkey(),SignatureAlgorithm.HS256)
        .compact();
    }
    private Claims getClaims(String token){
        return Jwts.parserBuilder()
        .setSigningKey(getSigningkey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }
    public String extractEmail(String token){
        return getClaims(token).getSubject();
    }
    public boolean validateToken(String token){
        try{
            getClaims(token);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    }

