package com.cloudsolux.foods.hr_service.domain.department.command;

import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

public final class DepartmentCreationCommand {

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

  public String getName() {
    return name;
  }
}