package com.cloudsolux.foods.hr_service.infra.employee.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;
import com.cloudsolux.foods.hr_service.infra.employee.entity.EmployeeEntity;

@Component
public final class EmployeeMapper {
  
  public EmployeeEntity toEntity(Employee domain) {
    EmployeeValidatorAux.validateArgument(domain, "Employee");

    return EmployeeEntity.builder()
      .id(domain.getId())
      .firstName(domain.getFirstName())
      .lastName(domain.getLastName())
      .birthday(domain.getBirthday())
      .email(domain.getEmail())
      .departmentId(domain.getDepartmentId())
      .build();
  }

  public Employee toDomain(EmployeeEntity entity) {
    EmployeeValidatorAux.validateArgument(entity, "EmployeeEntity");

    return Employee.builder()
      .id(entity.getId())
      .firstName(entity.getFirstName())
      .lastName(entity.getLastName())
      .birthday(entity.getBirthday())
      .email(entity.getEmail())
      .departmentId(entity.getDepartmentId())
      .build();
  }
}