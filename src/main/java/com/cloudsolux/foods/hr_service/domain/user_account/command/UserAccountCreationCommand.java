package com.cloudsolux.foods.hr_service.domain.user_account.command;

import java.time.LocalDate;

import com.cloudsolux.foods.global_services.domain.global.model.Role;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;

public final class UserAccountCreationCommand {

  private final String firstName;
  private final String lastName;
  private final LocalDate birthday;
  private final String email;
	private final Role role;
  private final String password;
  private final Boolean active;
 
  private UserAccountCreationCommand(UserAccountCreationCommandBuilder builder) {
    UserAccountValidationAux.validateString(builder.firstName, "firstName");
    UserAccountValidationAux.validateString(builder.lastName, "lastName");
    UserAccountValidationAux.validateAgeSixteen(builder.birthday, "LocalDate");
    UserAccountValidationAux.validateEmail(builder.email, "email");
    UserAccountValidationAux.validateArgument(builder.role, "role");
    UserAccountValidationAux.validatePassword(builder.password, "password");
    UserAccountValidationAux.validateArgument(builder.active, "Boolean");
    firstName = builder.firstName;
    lastName = builder.lastName;
    birthday = builder.birthday;
    email = builder.email;
    role = builder.role;
    password = builder.password;
    active = builder.active;
  }

  public static class UserAccountCreationCommandBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private Role role;
    private String password;
    private Boolean active;

    public UserAccountCreationCommandBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public UserAccountCreationCommandBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public UserAccountCreationCommandBuilder birthday(LocalDate birthday) {
      this.birthday = birthday;
      return this;
    }

    public UserAccountCreationCommandBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UserAccountCreationCommandBuilder role(Role role) {
      this.role = role;
      return this;
    }

    public UserAccountCreationCommandBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserAccountCreationCommandBuilder active(Boolean active) {
      this.active = active;
      return this;
    }

    public UserAccountCreationCommand build() {
      return new UserAccountCreationCommand(this);
    }
  }

  public static UserAccountCreationCommandBuilder builder() {
    return new UserAccountCreationCommandBuilder();
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

  public Role getRole() {
    return role;
  }

  public String getPassword() {
    return password;
  }

  public Boolean getActive() {
    return active;
  }
}