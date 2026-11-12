package com.cloudsolux.foods.hr_service.infra.department.adapter.persistence;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessResourceFailureException;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentPersistenceException;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentMapper;

@ExtendWith(MockitoExtension.class)
class DepartmentPersistenceAdapterTest {

  @Mock
  private DepartmentRepo repo;

  @Mock
  private DepartmentMapper mapper;

  @InjectMocks
  private DepartmentPersistenceAdapter adapter;

  @Test
  void shouldReturnDepartmentPersistenceKey() {
    assertEquals(
      DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE,
      adapter.getKey()
    );
  }

  @Test
  void shouldSaveDepartmentSuccessfully() {
    Department domain = Department.builder()
      .id(1L)
      .name("Finance")
      .build();

    DepartmentEntity entity = DepartmentEntity.builder()
      .id(1L)
      .name("Finance")
      .build();

    when(mapper.toEntity(domain))
      .thenReturn(entity);

    assertDoesNotThrow(() ->
      adapter.save(domain)
    );
  }

  @Test
  void shouldThrowExceptionWhenMapperReturnsNull() {
    Department domain = Department.builder()
      .id(1L)
      .name("Finance")
      .build();

    when(mapper.toEntity(domain))
      .thenReturn(null);

    assertThrows(
      DepartmentInvalidDependencyException.class,
      () -> adapter.save(domain)
    );
  }

  @Test
  void shouldThrowPersistenceExceptionWhenSaveFails() {
    Department domain = Department.builder()
      .id(1L)
      .name("Finance")
      .build();

    DepartmentEntity entity = DepartmentEntity.builder()
      .id(1L)
      .name("Finance")
      .build();

    when(mapper.toEntity(domain))
      .thenReturn(entity);

    doThrow(new DataAccessResourceFailureException("DB error"))
      .when(repo)
      .save(entity);

    assertThrows(
      DepartmentPersistenceException.class,
      () -> adapter.save(domain)
    );
  }
}