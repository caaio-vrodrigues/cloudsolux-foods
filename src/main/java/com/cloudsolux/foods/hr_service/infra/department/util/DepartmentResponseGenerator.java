package com.cloudsolux.foods.hr_service.infra.department.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

@Component
public final class DepartmentResponseGenerator {
 
  public DepartmentResponse toDepartmentResponse(Department domain) {
    DepartmentValidationAux.validateArgument(domain, "Department");
    return DepartmentResponse.builder()
      .id(domain.getId())
      .name(domain.getName())
      .build();
  }
}