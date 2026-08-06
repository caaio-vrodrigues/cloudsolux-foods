package com.cloudsolux.foods.hr_service.domain.user_account;

import java.time.LocalDate;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.Role;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;

public final class UserAccount {

  private final Long id;
  private final String firstName;
  private final String lastName;
  private final LocalDate birthday;
  private final String email;
	private final Role role;
  private final String password;
  private final Boolean active;
  
  private UserAccount(UserAccountBuilder builder) {
    UserAccountValidationAux.validatePositive(builder.id, "id");
    UserAccountValidationAux.validateString(builder.firstName, "firstName");
    UserAccountValidationAux.validateString(builder.lastName, "lastName");
    UserAccountValidationAux.validateAgeSixteen(builder.birthday, "birthday");
    UserAccountValidationAux.validateEmail(builder.email, "email");
    UserAccountValidationAux.validateArgument(builder.role, "Role");
    UserAccountValidationAux.validateEncodedPassword(builder.password, "password");
    UserAccountValidationAux.validateArgument(builder.active, "Boolean");
    id = builder.id;
    firstName = builder.firstName;
    lastName = builder.lastName;
    birthday = builder.birthday;
    email = builder.email;
    role = builder.role;
    password = builder.password;
    active = builder.active;
  }

  public static class UserAccountBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private Role role;
    private String password;
    private boolean active;

    public UserAccountBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public UserAccountBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public UserAccountBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public UserAccountBuilder birthday(LocalDate birthday) {
      this.birthday = birthday;
      return this;
    }

    public UserAccountBuilder email(String email) {
      this.email = email;
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

  public Role getRole() {
    return role;
  }

  public String getPasswordHash() {
    return password;
  }

  public Boolean getActive() {
    return active;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof UserAccount other)) return false;
		return Objects.equals(email, other.email);
  }

  @Override
  public String toString() {
    return "UserAccount: ['id="+id+"', 'firstName="+firstName+"', 'lastName="+lastName+"', 'birthday="+birthday
      +"', 'email="+email+"', 'role="+role+"', 'active="+active+"']";
  }
}