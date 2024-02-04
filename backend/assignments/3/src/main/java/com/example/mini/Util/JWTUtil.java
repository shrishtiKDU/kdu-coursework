package com.example.mini.Util;

import com.example.mini.DTO.UserRegisterRequest;
import com.example.mini.config.PersonAuthConfig;
import com.example.mini.filter.TokenGeneratorFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class JWTUtil {
    private final PersonAuthConfig personAuthConfig;
    private final TokenGeneratorFilter tokenGeneratorFilter;

    @Autowired
    public JWTUtil(PersonAuthConfig personAuthConfig, PersonAuthConfig personAuthConfig1,
                   TokenGeneratorFilter tokenGeneratorFilter) {
        this.personAuthConfig = personAuthConfig1;
        this.tokenGeneratorFilter = tokenGeneratorFilter;
    }

    public String getTokenNew(UserRegisterRequest userRegisterRequest){
        Authentication authentication = personAuthConfig.authenticate(
                new UsernamePasswordAuthenticationToken(userRegisterRequest.getUsername(), userRegisterRequest.getPassword())
        );
        return tokenGeneratorFilter.generateJWT(authentication);
    }
    public String decodeToken(String token){
        String secretKey = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return String.valueOf(claims.get("username"));
    }
}
