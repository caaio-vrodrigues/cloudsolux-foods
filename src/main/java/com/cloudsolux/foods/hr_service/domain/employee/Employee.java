package com.cloudsolux.foods.hr_service.domain.employee;

import java.util.Objects;

import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;

public final class Employee {
  
  private final Long id;
  private final Long userAccountId;
  private final Long departmentId;

  private Employee(EmployeeBuilder builder) {
    EmployeeValidationAux.validatePositive(builder.id, "id");
    EmployeeValidationAux.validatePositive(builder.userAccountId, "userAccountId");
    EmployeeValidationAux.validatePositive(builder.departmentId, "departmentId");
    id = builder.id;
    userAccountId = builder.userAccountId;
    departmentId = builder.departmentId;
  }

  public static class EmployeeBuilder {
    private Long id;
    private Long userAccountId;
    private Long departmentId;

    public EmployeeBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public EmployeeBuilder userAccountId(Long userAccountId) {
      this.userAccountId = userAccountId;
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

  public Long getUserAccountId() {
    return userAccountId;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  @Override
  public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Employee other)) return false;
		return Objects.equals(id, other.id);
	}
	
  @Override
	public int hashCode() {
		return Objects.hash(id);
	}

  @Override
  public String toString() {
    return "Employee: ['id="+id+"', 'userAccountId="+userAccountId+"', 'departmentId="+departmentId+"']";
  }
}