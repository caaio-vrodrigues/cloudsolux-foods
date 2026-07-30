package com.cloudsolux.foods.hr_service.domain.employee;

import java.time.LocalDate;
import java.util.Objects;

import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

public final class Employee {
  
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final LocalDate birthday;
  private final String email;
  private final Long departmentId;

  private Employee(EmployeeBuilder builder) {
    EmployeeValidatorAux.validatePositiveLong(builder.id, "id");
    EmployeeValidatorAux.validateString(builder.firstName, "firstName");
    EmployeeValidatorAux.validateString(builder.lastName, "lastName");
    EmployeeValidatorAux.validateArgument(builder.birthday, "birthday");
    EmployeeValidatorAux.validateString(builder.email, "email");
    EmployeeValidatorAux.validatePositiveLong(builder.departmentId, "departmentId");
    id = builder.id;
    firstName = builder.firstName;
    lastName = builder.lastName;
    birthday = builder.birthday;
    email = builder.email;
    departmentId = builder.departmentId;
  }

  public static class EmployeeBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private Long departmentId;

    public EmployeeBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public EmployeeBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public EmployeeBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public EmployeeBuilder birthday(LocalDate birthday) {
      this.birthday = birthday;
      return this;
    }

    public EmployeeBuilder email(String email) {
      this.email = email;
      return this;
    }

    public EmployeeBuilder departmentId(Long departmentId) {
      this.departmentId = departmentId;
      return this;
    }

    public Employee build() {
      return new Employee(this);
    }
  }

  public static EmployeeBuilder builder() {
    return new EmployeeBuilder();
  }

  public Long getId() {
    return id;
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

  @Override
  public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Employee other)) return false;
		return Objects.equals(id, other.getId());
	}
	
  @Override
	public int hashCode() {
		return Objects.hash(id);
	}

  @Override
  public String toString() {
    return "Employee: ['id="+id+"', 'firstName="+firstName+"', 'lastName="+lastName+"', "+
      "'birthday="+birthday+"', 'email="+email+"', 'departmentId="+departmentId+"']";
  }
}