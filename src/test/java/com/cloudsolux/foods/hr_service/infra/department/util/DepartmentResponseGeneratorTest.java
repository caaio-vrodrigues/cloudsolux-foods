package com.cloudsolux.foods.hr_service.infra.department.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;

@ExtendWith(MockitoExtension.class)
class DepartmentResponseGeneratorTest {

  private final DepartmentResponseGenerator generator = new DepartmentResponseGenerator();

  @Test
  void shouldConvertDepartmentToDepartmentResponse() {
    Department department = Department.builder()
      .id(1L)
      .name("TI")
      .build();

    DepartmentResponse response = generator.toDepartmentResponse(department);

    assertNotNull(response);
    assertEquals(1L, response.getId());
    assertEquals("TI", response.getName());
  }

  @Test
  void shouldThrowExceptionWhenDepartmentIsNull() {
    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> generator.toDepartmentResponse(null)
    );
  }
}