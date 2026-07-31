package com.cloudsolux.foods.hr_service.app.employee.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidation;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;
import com.cloudsolux.foods.hr_service.infra.employee.util.EmployeeAdaptersGetter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeCreationHandler {

  private final EmployeeAdaptersGetter adapters;
  
  @Transactional
  public EmployeeResponse create(EmployeeCreationCommand command) {
    EmployeeValidatorAux.validateArgument(command, "EmployeeCreationCommand");
    EmployeeValidatorAux.validateDependency(adapters, "EmployeeAdaptersGetter");

    EmployeeValidation validator = (EmployeeValidation) adapters
      .getValidator(command.getValidationKey());
    
    EmployeeValidatorAux.validateDependency(validator, "EmployeeAdaptersGetter");
    validator.validateUniqueness(command.getEmail());

    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}