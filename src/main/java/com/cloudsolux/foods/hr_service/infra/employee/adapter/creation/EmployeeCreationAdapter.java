package com.cloudsolux.foods.hr_service.infra.employee.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreation;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationKey;

@Component
public final class EmployeeCreationAdapter implements EmployeeCreation {

  @Override
  public EmployeeCreationKey getKey() {
    return EmployeeCreationKey.EMPLOYEE_CREATION;
  }

  @Override
  public Employee create(Long employeeId, Long userAccountId, Long departmentId) {
    return Employee.builder()
      .id(employeeId)
      .userAccountId(userAccountId)
      .departmentId(departmentId)
      .build();
  }
}