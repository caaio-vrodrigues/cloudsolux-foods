package com.cloudsolux.foods.hr_service.domain.employee.util;

import java.time.LocalDate;
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

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateNull(
      dependency, 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Employee", dependencyType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Employee", dependencyType)), 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Employee", dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", implementationsType)), 
      () -> new EmployeeInvalidDependencyException(GlobalMsgCreator
        .emptyImplementationList("Employee", implementationsType))
    );
  }

  public static void validateEmail(String email, String argumentName) {
    ValidationAux.validateEmail(
      email, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)),
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .invalidEmailFormatMsg("Employee", email, argumentName))
    );
  }

  public static void validateAgeSixteen(LocalDate birthday, String argumentName) {
    ValidationAux.validateAgeSixteen(
      birthday,
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)),
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .minimumAgeSixteenMsg("Employee", argumentName, birthday))
    );
  }

  public static void validateEncodedPassword(String encoded, String argumentName) {
    ValidationAux.validateEncodedPassword(
      encoded, 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName)), 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Employee", argumentName)), 
      () -> new EmployeeInvalidArgumentException(GlobalMsgCreator
        .invalidPasswordHashMsg("Employee", argumentName))
    );
  }
}