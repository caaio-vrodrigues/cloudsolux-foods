package com.cloudsolux.foods.hr_service.app.employee.dto;

import java.time.LocalDate;

import com.cloudsolux.foods.global_services.domain.global.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public final class EmployeeResponse {
  
  @NotNull @Positive
  private Long id;

  @NotNull @Positive
  private Long departmentId;

  @NotNull @Positive
  private Long userAccountId;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotNull
  private LocalDate birthday;

  @NotBlank @Email
  private String email;

  @NotNull
  private Role role;

  @NotNull
  private Boolean active;
}