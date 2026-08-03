package com.cloudsolux.foods.hr_service.domain.user_account.util;

import java.time.LocalDate;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidDependencyException;

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

  public static void validateEmail(String email, String argumentName) {
    ValidationAux.validateEmail(
      email, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentName)),
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .invalidEmailFormatMsg("UserAccount", email, argumentName))
    );
  }

  public static void validateEncodedPassword(String encoded, String argumentName) {
    ValidationAux.validateEncodedPassword(
      encoded, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentName)), 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("UserAccount", argumentName)), 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .invalidPasswordHashMsg("UserAccount", argumentName))
    );
  }

  public static void validateAgeSixteen(LocalDate birthday, String argumentName) {
    ValidationAux.validateAgeSixteen(
      birthday,
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentName)),
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .minimumAgeSixteenMsg("UserAccount", argumentName, birthday))
    );
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateDependency(
      dependency, 
      () -> new UserAccountInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Department", dependencyType))
    );
  }
}