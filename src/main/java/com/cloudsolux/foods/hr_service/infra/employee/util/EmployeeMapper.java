package com.cloudsolux.foods.hr_service.infra.employee.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;
import com.cloudsolux.foods.hr_service.infra.employee.entity.EmployeeEntity;

@Component
public final class EmployeeMapper {
  
  public EmployeeEntity toEntity(Employee domain) {
    EmployeeValidationAux.validateArgument(domain, "Employee");

    return EmployeeEntity.builder()
      .id(domain.getId())
      .userAccountId(domain.getUserAccountId())
      .departmentId(domain.getDepartmentId())
      .build();
  }

  public Employee toDomain(EmployeeEntity entity) {
    EmployeeValidationAux.validateArgument(entity, "EmployeeEntity");

    return Employee.builder()
      .id(entity.getId())
      .userAccountId(entity.getUserAccountId())
      .departmentId(entity.getDepartmentId())
      .build();
  }
}