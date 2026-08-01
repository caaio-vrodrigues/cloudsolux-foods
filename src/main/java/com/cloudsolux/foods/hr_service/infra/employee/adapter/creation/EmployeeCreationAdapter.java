package com.cloudsolux.foods.hr_service.infra.employee.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreation;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationKey;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

@Component
public final class EmployeeCreationAdapter implements EmployeeCreation {

  @Override
  public EmployeeCreationKey getKey() {
    return EmployeeCreationKey.EMPLOYEE_CREATION;
  }

  @Override
  public Employee create(EmployeeCreationCommand command, Long id) {
    EmployeeValidatorAux.validateArgument(command, "EmployeeCreationcommand");
    EmployeeValidatorAux.validatePositiveLong(id, "id");

    return Employee.builder()
      .id(id)
      .firstName(command.getFirstName())
      .lastName(command.getLastName())
      .birthday(command.getBirthday())
      .email(command.getEmail())
      .departmentId(command.getDepartmentId())
      .build();
  }
}