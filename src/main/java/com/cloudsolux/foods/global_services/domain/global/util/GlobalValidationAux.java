package com.cloudsolux.foods.global_services.domain.global.util;

import com.cloudsolux.foods.global_services.domain.global.exception.GlobalInvalidArgumentException;

public final class GlobalValidationAux {

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
      argument, 
      () -> new GlobalInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Global", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new GlobalInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Global", argumentName)), 
      () -> new GlobalInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Global", argumentName)));
  }
}