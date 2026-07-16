package com.cloudsolux.foods.hr_service.infra.department.adapter.validation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentValidationAdapter implements DepartmentValidation {
  
  @Override
  public DepartmentValidationKey getKey() {
    return DepartmentValidationKey.VALIDATE_CREATION;
  }

  @Override
  public void validateUniqueness(DepartmentCreationCommand command) {
    throw new UnsupportedOperationException("Unimplemented method 'validateUniqueness'");
  }
}