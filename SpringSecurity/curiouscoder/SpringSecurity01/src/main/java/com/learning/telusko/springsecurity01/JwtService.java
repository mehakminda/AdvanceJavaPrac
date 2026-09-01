package com.learning.telusko.springsecurity01;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    public static final String SECRET= ",.ah3m=tzTY+E4HAy+3%md460^GgZTKq&007%d|LU*P";


    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30)) // half an hour from now
                .addClaims(new HashMap<>())
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();


    }
    private Key getSignedKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public Claims verifySignatureAndExtractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(getSignedKey())
                .build()
                .parseSignedClaims(token)
                .getBody();

        //Claims = claims + subject+ issued at + expired date..

    }

    public String extractUsername(String token){
        return verifySignatureAndExtractAllClaims(token).getSubject();
    }

    public Date getExpiration(String token){
        return verifySignatureAndExtractAllClaims(token).getExpiration();
    }

    public boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());

    }
}

/**
 * .signWith(getSignedKey(), SignatureAlgorithm.HS256) what is key and what is algorithm
 */