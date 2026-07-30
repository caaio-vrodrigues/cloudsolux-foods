package com.cloudsolux.foods.hr_service.domain.department.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;

public final class DepartmentValidationAux {
  
  private DepartmentValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(argument, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentName)), 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Department", argumentName))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentName)), 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Department", argumentName, BigDecimal.valueOf(value)))
    );
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateDependency(dependencyType, 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateDependencyMap(
      dependency, 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType)), 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList(dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateRegistryCreation(
      implementations, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", implementationsType)), 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .emptyImplementationList(implementationsType))
    );
  }
}
