package com.cloudsolux.foods.hr_service.domain.user_account.util;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidArgumentException;

public final class UserAccountValidationAux {

  private UserAccountValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentName)), 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("UserAccount", argumentName))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentName)), 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("UserAccount", argumentName, value))
    );
  }
}