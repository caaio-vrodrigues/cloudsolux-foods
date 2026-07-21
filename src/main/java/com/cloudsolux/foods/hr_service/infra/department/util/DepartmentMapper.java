package com.cloudsolux.foods.hr_service.infra.department.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;

@Component
public class DepartmentMapper {
 
  public DepartmentEntity toEntity(Department domain) {
    if(!(domain instanceof Department)) {
      String receivedClassName = domain != null ? 
        domain.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("Department", receivedClassName));
    }
    return DepartmentEntity.builder()
      .id(domain.getId())
      .name(domain.getName())
      .build();
  }

  public Department toDomain(DepartmentEntity entity) {
    if(!(entity instanceof DepartmentEntity)) {
      String receivedClassName = entity != null ? 
        entity.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("DepartmentEntity", receivedClassName));
    }
    return Department.builder()
      .id(entity.getId())
      .name(entity.getName())
      .build();
  }
}