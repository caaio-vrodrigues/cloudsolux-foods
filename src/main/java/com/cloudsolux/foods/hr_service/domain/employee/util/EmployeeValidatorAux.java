package com.cloudsolux.foods.hr_service.domain.employee.util;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeInvalidArgumentException;

public final class EmployeeValidatorAux {
  
  private EmployeeValidatorAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)), 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Employee", argumentName))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)), 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Employee", argumentName, BigDecimal.valueOf(value)))
    );
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateDependency(
      dependency, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullDependencyMsg("Employee", dependencyType))
    );
  }
}