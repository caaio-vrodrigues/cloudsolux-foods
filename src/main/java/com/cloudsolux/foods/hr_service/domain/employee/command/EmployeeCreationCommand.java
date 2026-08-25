package com.cloudsolux.foods.hr_service.domain.employee.command;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;

public final class EmployeeCreationCommand {
  
  private final Long departmentId;

  private EmployeeCreationCommand(EmployeeCreationCommandBuilder builder) {
    EmployeeValidationAux.validatePositive(builder.departmentId, "departmentId");
    departmentId = builder.departmentId;
  }

  public static class EmployeeCreationCommandBuilder {
    private Long departmentId;

    public EmployeeCreationCommandBuilder departmentId(Long departmentId) {
      this.departmentId = departmentId;
      return this;
    }

    public EmployeeCreationCommand build() {
      return new EmployeeCreationCommand(this);
    }
  }

  public static EmployeeCreationCommandBuilder builder() {
    return new EmployeeCreationCommandBuilder();
  }

  public Long getDepartmentId() {
    return departmentId;
  }
}