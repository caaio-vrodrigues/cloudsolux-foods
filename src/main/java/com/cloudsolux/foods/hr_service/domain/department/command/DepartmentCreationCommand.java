package com.cloudsolux.foods.hr_service.domain.department.command;

import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;

public class DepartmentCreationCommand {
  
  public DepartmentValidationKey getValidationKey() {
    return DepartmentValidationKey.VALIDATE_CREATION;
  }
}