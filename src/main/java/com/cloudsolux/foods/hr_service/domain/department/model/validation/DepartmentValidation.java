package com.cloudsolux.foods.hr_service.domain.department.model.validation;

import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;

public interface DepartmentValidation extends DepartmentValidationPort {
 
  void validateUniqueness(DepartmentCreationCommand command);
}