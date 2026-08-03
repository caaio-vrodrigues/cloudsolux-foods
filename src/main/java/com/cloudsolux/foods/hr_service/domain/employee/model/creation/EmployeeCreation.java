package com.cloudsolux.foods.hr_service.domain.employee.model.creation;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;

public interface EmployeeCreation extends EmployeeCreationPort {
  
  Employee create(Long employeeId, Long userAccountId, Long departmentId);
}