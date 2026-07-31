package com.cloudsolux.foods.hr_service.infra.employee.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationPort;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeAdaptersGetter {
  
  private final Map<EmployeeValidationKey, EmployeeValidationPort> employeeValidators;

  public EmployeeValidationPort getValidator(EmployeeValidationKey key) {
    EmployeeValidatorAux.validateArgument(
      key, 
      "EmployeeValidationKey");

    EmployeeValidatorAux.validateDependencyMap(
      employeeValidators, 
      "Map<EmployeeValidationKey, EmployeeValidationPort>");

    return employeeValidators.get(key);
  }
}