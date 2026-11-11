package com.cloudsolux.foods.hr_service.infra.department.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;

@ExtendWith(MockitoExtension.class)
public class DepartmentMapperTest {
  
  private final DepartmentMapper departmentMapper = new DepartmentMapper();

  @Test
  @DisplayName("Deve converter Department para DepartmentEntity")
  void toEntity_ReturnsDepartmentEntity() {
    Department department = Department.builder()
      .id(1L)
      .name("RH")
      .build();

    DepartmentEntity entity = departmentMapper.toEntity(department);

    assertNotNull(entity);
    assertEquals(1L, entity.getId());
    assertEquals("RH", entity.getName());
  }

  @Test
  @DisplayName("Deve converter DepartmentEntity para Department")
  void toDomain_ReturnsDepartment() {
    DepartmentEntity entity = DepartmentEntity.builder()
      .id(1L)
      .name("RH")
      .build();

    Department department = departmentMapper.toDomain(entity);

    assertNotNull(department);
    assertEquals(1L, department.getId());
    assertEquals("RH", department.getName());
  }
}