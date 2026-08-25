package com.cloudsolux.foods.hr_service.infra.department.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationPort;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistencePort;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class DepartmentAdaptersGetter {
 
  private final Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators;
  private final Map<DepartmentCreationKey, DepartmentCreationPort> departmentFactories;
  private final Map<DepartmentPersistenceKey, DepartmentPersistencePort> departmentPersistences;

  public DepartmentValidationPort getValidator(DepartmentValidationKey key) {
    DepartmentValidationAux.validateArgument(key, "DepartmentValidationKey");

    DepartmentValidationAux.validateDependencyMap(
      departmentValidators, 
      "Map<DepartmentValidationKey, DepartmentValidationPort>");

    DepartmentValidationPort validator = departmentValidators.get(key);

    DepartmentValidationAux.validateDependencyResult(
      validator, 
      "departmentValidators", 
      "DepartmentValidationPort");

    return validator;
  }

  public DepartmentCreationPort getFactory(DepartmentCreationKey key) {
    DepartmentValidationAux.validateArgument(key, "DepartmentCreationKey");

    DepartmentValidationAux.validateDependencyMap(
      departmentFactories, 
      "Map<DepartmentCreationKey, DepartmentCreationPort>");

    DepartmentCreationPort factory = departmentFactories.get(key);

    DepartmentValidationAux.validateDependencyResult(
      factory, 
      "departmentFactories", 
      "DepartmentCreationPort");

    return factory;
  }

  public DepartmentPersistencePort getPersistence(DepartmentPersistenceKey key) {
    DepartmentValidationAux.validateArgument(key, "DepartmentPersistenceKey");

    DepartmentValidationAux.validateDependencyMap(
      departmentPersistences, 
      "Map<DepartmentPersistenceKey, DepartmentPersistencePort>");

    DepartmentPersistencePort persistence = departmentPersistences.get(key);

    DepartmentValidationAux.validateDependencyResult(
      persistence, 
      "departmentPersistences", 
      "DepartmentPersistencePort");

    return persistence;
  }
}