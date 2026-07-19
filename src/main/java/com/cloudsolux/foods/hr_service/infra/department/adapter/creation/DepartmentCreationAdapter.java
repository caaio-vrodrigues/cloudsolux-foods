package com.cloudsolux.foods.hr_service.infra.department.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;

@Component
public class DepartmentCreationAdapter implements DepartmentCreation {

  @Override
  public DepartmentCreationKey getKey() {
    return DepartmentCreationKey.DEPARTMENT_CREATION;
  }

  @Override
  public Department create(DepartmentCreationCommand command, Long id) {
    if(command == null) {
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("DepartmentEntity", "DepartmentCreationCommand"));
    }
    if(id == null) {
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("DepartmentEntity", "id"));
    }
    return Department.builder()
      .id(id)
      .name(command.getName())
      .build();
  }
}