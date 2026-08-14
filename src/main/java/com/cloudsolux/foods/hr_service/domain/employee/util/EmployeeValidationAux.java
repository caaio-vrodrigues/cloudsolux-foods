package com.cloudsolux.foods.hr_service.domain.employee.util;

import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeInvalidDependencyException;

public final class EmployeeValidationAux {
  
  private EmployeeValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
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

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)), 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Employee", argumentName, value))
    );
  }

  public static void validateDependencyResult(
    Object dependency, String dependencyType, String resultType
  ) {
    ValidationAux.validateNull(
      dependency, 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("Employee", dependencyType, resultType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg("Employee", dependencyType)), 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Employee", dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", implementationsType)),
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullListElementMsg("Employee", implementationsType)),
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .emptyImplementationList("Employee", implementationsType))
    );
  }
}