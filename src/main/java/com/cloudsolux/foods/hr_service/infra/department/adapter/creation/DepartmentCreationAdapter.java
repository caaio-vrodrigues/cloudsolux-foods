package com.cloudsolux.foods.hr_service.infra.department.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

@Component
public final class DepartmentCreationAdapter implements DepartmentCreation {

  @Override
  public DepartmentCreationKey getKey() {
    return DepartmentCreationKey.DEPARTMENT_CREATION;
  }

  @Override
  public Department create(DepartmentCreationCommand command, Long id) {
    DepartmentValidationAux.validateArgument(command, "DepartmentCreationCommand");
      
    return Department.builder()
      .id(id)
      .name(command.getName())
      .build();
  }
}