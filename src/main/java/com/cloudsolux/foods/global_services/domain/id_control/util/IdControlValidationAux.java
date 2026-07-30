package com.cloudsolux.foods.global_services.domain.id_control.util;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;

public final class IdControlValidationAux {
  
  private IdControlValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", argumentType))
    );
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateDependency(
      dependency, 
      () -> new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("IdControl", dependencyType))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", argumentName)), 
      () -> new IdControlInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("IdControl", argumentName, value))
    );
  }
}