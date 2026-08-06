package com.cloudsolux.foods.hr_service.infra.employee.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationPort;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistenceKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistencePort;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class EmployeeAdaptersGetter {
  
  private final Map<EmployeeCreationKey, EmployeeCreationPort> employeeFactories;
  private final Map<EmployeePersistenceKey, EmployeePersistencePort> employeePersistences;

  public EmployeeCreationPort getFactories(EmployeeCreationKey key) {
    EmployeeValidationAux.validateArgument(key, "EmployeeCreationKey");

    EmployeeValidationAux.validateDependencyMap(
      employeeFactories, 
      "Map<EmployeeCreationKey, EmployeeCreationPort>");

    return employeeFactories.get(key);
  }

  public EmployeePersistencePort getPersistences(EmployeePersistenceKey key) {
    EmployeeValidationAux.validateArgument(key, "EmployeePersistenceKey");

    EmployeeValidationAux.validateDependencyMap(
      employeePersistences, 
      "Map<EmployeePersistenceKey, EmployeePersistencePort>");

    return employeePersistences.get(key);
  }
}