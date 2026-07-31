package com.cloudsolux.foods.hr_service.api.employee.dto;

import java.time.LocalDate;

import com.cloudsolux.foods.hr_service.infra.employee.command.EmployeeCreationCommand;

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
public final class EmployeeCreationRequest {
  
  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotNull
  private LocalDate birthday;

  @NotBlank @Email
  private String email;

  @NotNull @Positive
  private Long departmentId;

  public EmployeeCreationCommand toCommand() {
    return EmployeeCreationCommand.builder()
      .firstName(firstName)
      .lastName(lastName)
      .birthday(birthday)
      .email(email)
      .departmentId(departmentId)
      .build();
  }
}