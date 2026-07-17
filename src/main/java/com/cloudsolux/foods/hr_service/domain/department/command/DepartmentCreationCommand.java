package com.cloudsolux.foods.hr_service.domain.department.command;

import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;

public class DepartmentCreationCommand {
  
  public DepartmentValidationKey getValidationKey() {
    return DepartmentValidationKey.VALIDATE_CREATION;
  }

  public DepartmentCreationKey getFactoryKey() {
    return DepartmentCreationKey.DEPARTMENT_CREATION;
  }

  public DepartmentPersistenceKey getPersistenceKey() {
    return DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE;
  }
}