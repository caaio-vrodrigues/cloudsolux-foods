package com.cloudsolux.foods.hr_service.app.security.handler;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.cloudsolux.foods.hr_service.app.security.dto.LoginResponse;
import com.cloudsolux.foods.hr_service.domain.security.LoginRequestCommand;
import com.cloudsolux.foods.hr_service.domain.security.model.TokenManagerPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationHandler {

  private final TokenManagerPort tokenService;
  private final AuthenticationManager authenticationManager;

  public LoginResponse authenticate(
    LoginRequestCommand request
  ) {
    UsernamePasswordAuthenticationToken authToken = 
      new UsernamePasswordAuthenticationToken(
        request.getEmail(), 
        request.getPassword());

    Authentication authentication = authenticationManager
      .authenticate(authToken);

    String token = tokenService.generateToken(authentication.getName());

    return LoginResponse.builder()
      .token(token)
      .build();
  }
}