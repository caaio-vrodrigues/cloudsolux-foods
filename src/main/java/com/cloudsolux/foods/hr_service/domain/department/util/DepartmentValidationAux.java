package com.cloudsolux.foods.hr_service.domain.department.util;

import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentNotFoundException;

public final class DepartmentValidationAux {
  
  private DepartmentValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
      argument, 
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

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentName)), 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Department", argumentName, value))
    );
  }

  public static void validateDependencyResult(
    Object adapter, String dependencyName, String resultType
  ) {
    ValidationAux.validateNull(
      adapter, 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("Department", dependencyName, resultType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg("Department", dependencyType)), 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Department", dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", implementationsType)),
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .emptyImplementationList("Department", implementationsType))
    );
  }

  public static void validateUniqueness(Boolean existsByName, String name) {
    if(existsByName == null) 
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", "existsByName"));

    if(name == null) 
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", "name"));

    if(existsByName)
      throw new DepartmentAlreadyExistsException(DepartmentMsgCreator
        .uniquenessViolationMsg(name));
  }

  public static void validateExistenceById(Boolean existsById, Long departmentId) {
    ValidationAux.validateExistenceById(
      existsById, 
      () -> new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", "existsById")), 
      () -> new DepartmentNotFoundException(GlobalMsgCreator
        .notFoundMsg("Department", departmentId)));
  } 
}