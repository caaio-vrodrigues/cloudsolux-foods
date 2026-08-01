package com.cloudsolux.foods.hr_service.infra.employee.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationPort;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationPort;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeAdaptersGetter {
  
  private final Map<EmployeeValidationKey, EmployeeValidationPort> employeeValidators;
  private final Map<EmployeeCreationKey, EmployeeCreationPort> employeeFactories;

  public EmployeeValidationPort getValidator(EmployeeValidationKey key) {
    EmployeeValidatorAux.validateArgument(
      key, 
      "EmployeeValidationKey");

    EmployeeValidatorAux.validateDependencyMap(
      employeeValidators, 
      "Map<EmployeeValidationKey, EmployeeValidationPort>");

    return employeeValidators.get(key);
  }

  public EmployeeCreationPort getFactories(EmployeeCreationKey key) {
    EmployeeValidatorAux.validateArgument(
      key, 
      "EmployeeCreationKey");

    EmployeeValidatorAux.validateDependencyMap(
      employeeFactories, 
      "Map<EmployeeCreationKey, EmployeeCreationPort>");

    return employeeFactories.get(key);
  }
}