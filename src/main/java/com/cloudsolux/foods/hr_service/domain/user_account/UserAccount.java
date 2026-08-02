package com.cloudsolux.foods.hr_service.domain.user_account;

import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.Role;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;

public final class UserAccount {

  private final Long employeeId;
	private final Role role;
  private final String password;
  private final Boolean active;
  
  private UserAccount(UserAccountBuilder builder) {
    UserAccountValidationAux.validatePositiveLong(builder.employeeId, "employeeId");
    UserAccountValidationAux.validateArgument(builder.role, "Role");
    UserAccountValidationAux.validateString(builder.password, "password");
    UserAccountValidationAux.validateArgument(builder.active, "Boolean");

    employeeId = builder.employeeId;
    role = builder.role;
    password = builder.password;
    active = builder.active;
  }

  public static class UserAccountBuilder {
    private Long employeeId;
    private Role role;
    private String password;
    private boolean active;

    public UserAccountBuilder employeeId(Long employeeId) {
      this.employeeId = employeeId;
      return this;
    }

    public UserAccountBuilder role(Role role) {
      this.role = role;
      return this;
    }

    public UserAccountBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserAccountBuilder active(boolean active) {
      this.active = active;
      return this;
    }

    public UserAccount build() {
      return new UserAccount(this);
    }
  }

  public static UserAccountBuilder builder() {
    return new UserAccountBuilder();
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public Role getRole() {
    return role;
  }

  public String getPassword() {
    return password;
  }

  public boolean isActive() {
    return active;
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof UserAccount other)) return false;
		return Objects.equals(employeeId, other.employeeId);
  }

  @Override
  public String toString() {
    return "UserAccount: ['employeeId="+employeeId+"', 'role="+role+"', 'active="+active+"']";
  }
}