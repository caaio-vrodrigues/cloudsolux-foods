package com.cloudsolux.foods.hr_service.domain.user_account.util;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidDependencyException;

public final class UserAccountValidationAux {

  private UserAccountValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
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

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
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

  public static void validatePassword(String password, String argumentName) {
    ValidationAux.validatePassword(
      password, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", argumentName)), 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("UserAccount", argumentName)), 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .invalidPasswordLengthMsg("UserAccount", argumentName))
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

  public static void validateDependencyResult(
    Object adapter, String dependencyName, String resultType
  ) {
    ValidationAux.validateNull(
      adapter, 
      () -> new UserAccountInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("UserAccount", dependencyName, resultType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new UserAccountInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", dependencyType)), 
      () -> new UserAccountInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("UserAccount", dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", implementationsType)),
      () -> new UserAccountInvalidDependencyException(GlobalMsgCreator
        .emptyImplementationList("UserAccount", implementationsType))
    );
  }

  public static void validateUniqueness(Boolean existsByEmail, String email) {
    if(existsByEmail == null) 
      throw new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", "existsByEmail"));

    if(email == null) 
      throw new UserAccountInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("UserAccount", "email"));

    if(existsByEmail) 
      throw new UserAccountAlreadyExistsException(UserAccountMsgCreator
        .uniquenessViolationMsg(email));
  }
}