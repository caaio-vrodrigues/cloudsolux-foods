package com.cloudsolux.foods.hr_service.domain.employee.util;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeenvalidArgumentException;

public final class EmployeeValidatorAux {
  
  private EmployeeValidatorAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    if(argument == null)
      throw new EmployeenvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentType));
  }

  public static void validateString(String value, String argumentName) {
    if(value == null)
      throw new EmployeenvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName));
		if(value.isBlank())
      throw new EmployeenvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Employee", argumentName));
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    if(value == null)
      throw new EmployeenvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Employee", argumentName));
    if(value < 1)
      throw new EmployeenvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Employee", argumentName, BigDecimal.valueOf(value)));
  }
}