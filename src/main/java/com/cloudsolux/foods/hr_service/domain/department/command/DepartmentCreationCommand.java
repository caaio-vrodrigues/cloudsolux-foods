package com.cloudsolux.foods.hr_service.domain.department.command;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;

public class DepartmentCreationCommand {

  private final String name;

  private DepartmentCreationCommand(DepartmentCreationCommandBuilder builder) {
    name = builder.name;
  }

  public static class DepartmentCreationCommandBuilder {
    private String name;

    public DepartmentCreationCommandBuilder name(String name) {
      if(name == null) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("DepartmentEntity", "name"));
      }
      if(name.isBlank()) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("DepartmentEntity", "name"));
      }
      this.name = name;
      return this;
    }

    public DepartmentCreationCommand build() {
      if(name == null) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("DepartmentEntity", "name"));
      }
      return new DepartmentCreationCommand(this);
    }
  }

  public static DepartmentCreationCommandBuilder builder(){
    return new DepartmentCreationCommandBuilder();
  }

  public DepartmentValidationKey getValidationKey() {
    return DepartmentValidationKey.VALIDATE_CREATION;
  }

  public DepartmentCreationKey getFactoryKey() {
    return DepartmentCreationKey.DEPARTMENT_CREATION;
  }

  public DepartmentPersistenceKey getPersistenceKey() {
    return DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE;
  }

  public IdControlKey getIdGenerationKey() {
    return IdControlKey.DEPARTMENT_ID;
  }

  public String getName() {
    return name;
  }
}