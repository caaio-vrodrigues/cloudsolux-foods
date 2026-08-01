package com.cloudsolux.foods.hr_service.infra.employee.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

@Component
public final class EmployeeResponseGenerator {
  
  public EmployeeResponse toEmployeeResponse(Employee domain) {
    EmployeeValidatorAux.validateArgument(domain, "Employee");

    return EmployeeResponse.builder()
      .id(domain.getId())
      .firstName(domain.getFirstName())
      .lastName(domain.getLastName())
      .birthday(domain.getBirthday())
      .email(domain.getEmail())
      .departmentId(domain.getDepartmentId())
      .build();
  }
}