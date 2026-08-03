package com.cloudsolux.foods.hr_service.infra.user_account.entity;

import java.time.LocalDate;

import com.cloudsolux.foods.global_services.domain.global.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Getter
@Builder
@Entity
@Table(name="user_account")
public final class UserAccountEntity {
  
  @Id
  private Long id;

  @Column(name="first_name", nullable=false)
  private String firstName;

  @Column(name="last_name", nullable=false)
  private String lastName;

  @Column(name="birthday", nullable=false)
  private LocalDate birthday;

  @Include
  @Column(name="email", nullable=false, unique=true)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name="role", nullable=false)
  private Role role;

  @Column(name="password", nullable=false)
  private String password;

  @Column(name="active")
  private boolean active;

  @Override
  public String toString() {
    return "UserAccountEntity: ['id="+id+"', 'firstName="+firstName+"', 'lastName="+lastName+"', 'birthday="
      +birthday+"', 'email="+email+"', 'role="+role+"', 'active="+active+"']";
  }
}