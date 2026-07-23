package com.cloudsolux.foods.hr_service.infra.department.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;

@Component
public final class DepartmentMapper {
 
  public DepartmentEntity toEntity(Department domain) {
    DepartmentValidationAux.validateArgument(
      domain, "Department");

    return DepartmentEntity.builder()
      .id(domain.getId())
      .name(domain.getName())
      .build();
  }

  public Department toDomain(DepartmentEntity entity) {
    DepartmentValidationAux.validateArgument(
      entity, "DepartmentEntity");

    return Department.builder()
      .id(entity.getId())
      .name(entity.getName())
      .build();
  }
}