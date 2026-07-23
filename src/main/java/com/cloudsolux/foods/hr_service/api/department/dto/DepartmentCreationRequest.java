package com.cloudsolux.foods.hr_service.api.department.dto;

import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class DepartmentCreationRequest {
  
  @NotBlank
  private String name;

  public DepartmentCreationCommand toCommand() {
    return DepartmentCreationCommand.builder()
      .name(name)
      .build();
  }
}