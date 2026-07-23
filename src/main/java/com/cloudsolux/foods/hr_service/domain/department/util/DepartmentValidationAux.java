package com.cloudsolux.foods.hr_service.domain.department.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;

public final class DepartmentValidationAux {
  
  private DepartmentValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    if(argument == null)
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentType));
  }

  public static void validateString(String value, String argumentName) {
    if(value == null)
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentName));
		if(value.isBlank())
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Department", argumentName));
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    if(value == null)
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentName));
    if(value < 1)
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Department", argumentName, BigDecimal.valueOf(value)));
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    if(dependency == null)
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    if(dependency == null)
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
    if(dependency.isEmpty())
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList(dependencyType));
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    if(implementations == null)
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", implementationsType));
    if(implementations.isEmpty())
      throw new DepartmentInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList(implementationsType));
  }
}
