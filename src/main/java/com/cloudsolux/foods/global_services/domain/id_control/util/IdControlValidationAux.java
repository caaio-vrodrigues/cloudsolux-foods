package com.cloudsolux.foods.global_services.domain.id_control.util;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;

public final class IdControlValidationAux {
  
  private IdControlValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    if(argument == null)
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", argumentType));
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    if(dependency == null)
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
  }
}