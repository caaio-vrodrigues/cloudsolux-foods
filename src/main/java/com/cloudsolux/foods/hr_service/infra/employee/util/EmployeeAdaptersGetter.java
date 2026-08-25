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

  public EmployeeCreationPort getFactory(EmployeeCreationKey key) {
    EmployeeValidationAux.validateArgument(key, "EmployeeCreationKey");

    EmployeeValidationAux.validateDependencyMap(
      employeeFactories, 
      "Map<EmployeeCreationKey, EmployeeCreationPort>");

    EmployeeCreationPort adapter = employeeFactories.get(key);

    EmployeeValidationAux.validateDependencyResult(
      adapter, 
      "employeeFactories", 
      "EmployeeCreationPort");

    return adapter;
  }

  public EmployeePersistencePort getPersistence(EmployeePersistenceKey key) {
    EmployeeValidationAux.validateArgument(key, "EmployeePersistenceKey");

    EmployeeValidationAux.validateDependencyMap(
      employeePersistences, 
      "Map<EmployeePersistenceKey, EmployeePersistencePort>");

    EmployeePersistencePort adapter = employeePersistences.get(key);

    EmployeeValidationAux.validateDependencyResult(
      adapter, 
      "employeePersistences", 
      "EmployeePersistencePort");

    return adapter;
  }
}