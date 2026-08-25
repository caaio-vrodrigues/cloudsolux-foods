package com.cloudsolux.foods.hr_service.api.security.dto;

import com.cloudsolux.foods.hr_service.domain.security.LoginRequestCommand;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PROTECTED)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class LoginRequest {

  @NotBlank @Email
  private String email;

  @NotBlank @Size(min=8)
  private String password;

  public LoginRequestCommand toCommand() {
    return LoginRequestCommand.builder()
      .email(email)
      .password(password)
      .build();
  }
}