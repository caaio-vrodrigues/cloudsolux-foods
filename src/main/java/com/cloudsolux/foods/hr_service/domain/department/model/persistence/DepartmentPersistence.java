package com.cloudsolux.foods.hr_service.domain.department.model.persistence;

import com.cloudsolux.foods.hr_service.domain.department.Department;

public interface DepartmentPersistence extends DepartmentPersistencePort {
 
  void saveDepartment(Department domain);
}