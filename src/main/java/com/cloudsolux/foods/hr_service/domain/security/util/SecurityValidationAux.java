package com.cloudsolux.foods.hr_service.domain.security.util;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.security.exception.SecurityInvalidArgumentException;

public final class SecurityValidationAux {
  
  private SecurityValidationAux() {}

  public static void validateEmail(String email, String argumentName) {
    ValidationAux.validateEmail(
      email, 
      () -> new SecurityInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Security", argumentName)),
      () -> new SecurityInvalidArgumentException(GlobalMsgCreator
        .invalidEmailFormatMsg("Security", email, argumentName))
    );
  }

  public static void validatePassword(String password, String argumentName) {
    ValidationAux.validatePassword(
      password, 
      () -> new SecurityInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Security", argumentName)), 
      () -> new SecurityInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Security", argumentName)), 
      () -> new SecurityInvalidArgumentException(GlobalMsgCreator
        .invalidPasswordOnAccesMsg("Security", argumentName))
    );
  }
}