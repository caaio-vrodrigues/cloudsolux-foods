package com.cloudsolux.foods.hr_service.domain.employee.util;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeenvalidArgumentException;

public final class EmployeeValidatorAux {
  
  private EmployeeValidatorAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new EmployeenvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new EmployeenvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)), 
      () -> new EmployeenvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Employee", argumentName))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new EmployeenvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)), 
      () -> new EmployeenvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Employee", argumentName, BigDecimal.valueOf(value)))
    );
  }
}