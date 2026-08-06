package com.cloudsolux.foods.hr_service.domain.employee.command;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistenceKey;
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

  public IdControlKey getEmployeeIdControlKey() {
    return IdControlKey.EMPLOYEE_ID;
  }

  public EmployeeCreationKey getFactoryKey() {
    return EmployeeCreationKey.EMPLOYEE_CREATION;
  }

  public EmployeePersistenceKey getPersistenceKey() {
    return EmployeePersistenceKey.EMPLOYEE_PERSISTENCE;
  }

  public Long getDepartmentId() {
    return departmentId;
  }
}