package com.cloudsolux.foods.hr_service.infra.security.adapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.security.model.TokenManagerPort;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenManager implements TokenManagerPort {

  private final SecretKey key;
  private final long expiration;

  public TokenManager(
    @Value("${jwt.secret}") String secret,
    @Value("${jwt.expiration}") long expiration
  ) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    this.expiration = expiration;
  }

  @Override
  public String generateToken(String username) {
    return Jwts.builder()
      .subject(username)
      .issuedAt(new Date())
      .expiration(new Date(System.currentTimeMillis() + expiration))
      .signWith(key)
      .compact();
  }

  @Override
  public String validateToken(String token) {
    return Jwts.parser()
      .verifyWith(key)
      .build()
      .parseSignedClaims(token)
      .getPayload()
      .getSubject();
  }
}