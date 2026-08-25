package com.cloudsolux.foods.hr_service.domain.security.model;

public interface TokenManagerPort {
  
  String generateToken(String username);
  String validateToken(String token);
}