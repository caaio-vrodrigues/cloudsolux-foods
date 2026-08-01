package com.cloudsolux.foods.hr_service.domain.employee.model.persistence;

import com.cloudsolux.foods.hr_service.domain.employee.Employee;

public interface EmployeePersistence extends EmployeePersistencePort {
 
  void save(Employee employee);
}