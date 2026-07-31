package com.cloudsolux.foods.hr_service.domain.employee.command;

import java.time.LocalDate;

import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationKey;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

public final class EmployeeCreationCommand {
  
  private final String firstName;
  private final String lastName;
  private final LocalDate birthday;
  private final String email;
  private final Long departmentId;

  private EmployeeCreationCommand(EmployeeCreationCommandBuilder builder) {
    EmployeeValidatorAux.validateString(builder.firstName, "firstName");
    EmployeeValidatorAux.validateString(builder.lastName, "lastName");
    EmployeeValidatorAux.validateArgument(builder.birthday, "LocalDate");
    EmployeeValidatorAux.validateEmail(builder.email, "email");
    EmployeeValidatorAux.validatePositiveLong(builder.departmentId, "departmentId");
    firstName = builder.firstName;
    lastName = builder.lastName;
    birthday = builder.birthday;
    email = builder.email;
    departmentId = builder.departmentId;
  }

  public static class EmployeeCreationCommandBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private Long departmentId;

    public EmployeeCreationCommandBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public EmployeeCreationCommandBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public EmployeeCreationCommandBuilder birthday(LocalDate birthday) {
      this.birthday = birthday;
      return this;
    }

    public EmployeeCreationCommandBuilder email(String email) {
      this.email = email;
      return this;
    }

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

  public EmployeeValidationKey getValidationKey() {
    return EmployeeValidationKey.EMPLOYEE_VALIDATION;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public String getEmail() {
    return email;
  }

  public Long getDepartmentId() {
    return departmentId;
  }
}