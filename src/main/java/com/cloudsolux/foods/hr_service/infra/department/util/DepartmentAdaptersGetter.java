package com.cloudsolux.foods.hr_service.infra.department.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationPort;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistencePort;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentAdaptersGetter {
 
  private final Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators;
  private final Map<DepartmentCreationKey, DepartmentCreationPort> departmentFactories;
  private final Map<DepartmentPersistenceKey, DepartmentPersistencePort> departmentPersistences;

  public DepartmentValidationPort getValidator(DepartmentValidationKey key) {
    return departmentValidators.get(key);
  }

  public DepartmentCreationPort getFactory(DepartmentCreationKey key) {
    return departmentFactories.get(key);
  }

  public DepartmentPersistencePort getPersistence(DepartmentPersistenceKey key) {
    return departmentPersistences.get(key);
  }
}