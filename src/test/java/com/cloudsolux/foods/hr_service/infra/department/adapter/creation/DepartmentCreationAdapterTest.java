package com.cloudsolux.foods.hr_service.infra.department.adapter.creation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;

class DepartmentCreationAdapterTest {

  private final DepartmentCreationAdapter adapter =
    new DepartmentCreationAdapter();

  @Test
  void shouldReturnDepartmentCreationKey() {
    assertEquals(
      DepartmentCreationKey.DEPARTMENT_CREATION,
      adapter.getKey()
    );
  }

  @Test
  void shouldCreateDepartment() {
    DepartmentCreationCommand command =
      DepartmentCreationCommand.builder()
        .name("Finance")
        .build();

    Department department =
      adapter.create(command, 1L);

    assertNotNull(department);
    assertEquals(1L, department.getId());
    assertEquals("Finance", department.getName());
  }

  @Test
  void shouldThrowExceptionWhenCommandIsNull() {
    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> adapter.create(null, 1L)
    );
  }
}