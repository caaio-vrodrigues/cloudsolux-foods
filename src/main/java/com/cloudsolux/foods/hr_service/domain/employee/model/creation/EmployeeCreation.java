package com.cloudsolux.foods.hr_service.domain.employee.model.creation;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;

public interface EmployeeCreation extends EmployeeCreationPort {
  
  Employee create(EmployeeCreationCommand command, Long id);
}