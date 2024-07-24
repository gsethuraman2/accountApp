package com.example.demo.serviceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Service
public class JwtService {

    private static final String SECRET = "8CAB8D39D29EF7AFC8972BC997F562D5A4F0BEF89FC20638A849A662DAACC99FABBDC16DCFA3E2512A2C709FF9066BD70CA47A80E2A6CCCC69BC50020BFBB25F";

    private static final Long VALIDITY = TimeUnit.MINUTES.toMillis(30);

    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
                .signWith(generateSecretKey())
                .compact();

        // 112
        // 142 - expiration
    }

    private SecretKey generateSecretKey() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET));
    }

    public String extractUsername(String jwtToken){
        Claims claims = getClaims(jwtToken);
        return  claims.getSubject();
    }

    private Claims getClaims(String jwtToken) {
        return Jwts.parser()
                .verifyWith(generateSecretKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
    }

    public boolean isValidToken(String jwtToken){
        Claims claims = getClaims(jwtToken);
        return claims.getExpiration().after(Date.from(Instant.now()));

        // if the current timestamp is before jwt expiration timestamp
        // 120 -- current timestamp
        // 142 -- expiration
        // true

        // if the current timestamp is after jwt expiration timestamp
        // 152 -- current timestamp
        // 142 -- expiration
        // false

    }


}
