package com.cloudsolux.foods.hr_service.domain.security;

import com.cloudsolux.foods.hr_service.domain.security.util.SecurityValidationAux;

public final class LoginRequestCommand {

  private final String email;
  private final String password;
  
  private LoginRequestCommand(LoginRequestCommandBuilder builder) {
    SecurityValidationAux.validateEmail(builder.email, "email");
    SecurityValidationAux.validatePassword(builder.password, "password");
    email = builder.email;
    password = builder.password;
  }

  public static class LoginRequestCommandBuilder {
    private String email;
    private String password;

    public LoginRequestCommandBuilder email(String email) {
      this.email = email;
      return this;
    }

    public LoginRequestCommandBuilder password(String password) {
      this.password = password;
      return this;
    }

    public LoginRequestCommand build() {
      return new LoginRequestCommand(this);
    }
  }

  public static LoginRequestCommandBuilder builder() {
    return new LoginRequestCommandBuilder();
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}