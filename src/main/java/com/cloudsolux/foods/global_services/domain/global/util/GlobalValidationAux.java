package com.cloudsolux.foods.global_services.domain.global.util;

import com.cloudsolux.foods.global_services.domain.global.exception.GlobalInvalidArgumentException;

public class GlobalValidationAux {

  public static void validateArgument(Object argument, String argumentType) {
    if(argument == null)
      throw new GlobalInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentType));
  }

  public static void validateString(String value, String fieldName) {
    if(value == null)
      throw new GlobalInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", fieldName));
		if(value.isBlank())
      throw new GlobalInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Department", fieldName));
  }
}