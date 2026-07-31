package com.cloudsolux.foods.hr_service.domain.employee.model.validation;

public interface EmployeeValidation extends EmployeeValidationPort {
 
  void validateUniqueness(String email);
}