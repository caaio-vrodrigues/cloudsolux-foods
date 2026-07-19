package com.cloudsolux.foods.hr_service.domain.department.model.creation;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;

public interface DepartmentCreation extends DepartmentCreationPort {
 
  Department create(DepartmentCreationCommand command, Long id);
}