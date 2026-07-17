package com.cloudsolux.foods.hr_service.infra.department.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;

@Component
public class DepartmentCreationAdapter implements DepartmentCreation {

  @Override
  public DepartmentCreationKey getKey() {
    return DepartmentCreationKey.DEPARTMENT_CREATION;
  }

  @Override
  public Department create(DepartmentCreationCommand command) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}