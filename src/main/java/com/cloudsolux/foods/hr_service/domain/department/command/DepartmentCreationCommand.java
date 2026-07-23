package com.cloudsolux.foods.hr_service.domain.department.command;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

public class DepartmentCreationCommand {

  private final String name;

  private DepartmentCreationCommand(DepartmentCreationCommandBuilder builder) {
    DepartmentValidationAux.validateString(builder.name, "name");
    name = builder.name;
  }

  public static class DepartmentCreationCommandBuilder {
    private String name;

    public DepartmentCreationCommandBuilder name(String name) {
      this.name = name;
      return this;
    }

    public DepartmentCreationCommand build() {
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