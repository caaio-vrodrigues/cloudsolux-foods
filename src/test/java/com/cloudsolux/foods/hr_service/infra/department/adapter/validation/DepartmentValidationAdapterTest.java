package com.cloudsolux.foods.hr_service.infra.department.adapter.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessResourceFailureException;

import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentDataAccessException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentNotFoundException;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;

@ExtendWith(MockitoExtension.class)
class DepartmentValidationAdapterTest {

  @Mock
  private DepartmentRepo repo;

  @InjectMocks
  private DepartmentValidationAdapter adapter;

  @Test
  void shouldReturnValidateCreationKey() {
    assertEquals(
      DepartmentValidationKey.VALIDATE_CREATION,
      adapter.getKey()
    );
  }

  @Test
  void shouldValidateUniquenessWhenDepartmentDoesNotExist() {
    DepartmentCreationCommand command = DepartmentCreationCommand.builder()
      .name("Finance")
      .build();

    when(repo.existsByName("Finance"))
      .thenReturn(false);

    assertDoesNotThrow(() ->
      adapter.validateUniqueness(command)
    );
  }

  @Test
  void shouldThrowExceptionWhenDepartmentAlreadyExists() {
    DepartmentCreationCommand command = DepartmentCreationCommand.builder()
      .name("Finance")
      .build();

    when(repo.existsByName("Finance"))
      .thenReturn(true);

    assertThrows(
      DepartmentAlreadyExistsException.class,
      () -> adapter.validateUniqueness(command)
    );
  }

  @Test
  void shouldThrowExceptionWhenCommandIsNull() {
    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> adapter.validateUniqueness(null)
    );
  }

  @Test
  void shouldThrowDepartmentDataAccessExceptionWhenExistsByNameFails() {
    DepartmentCreationCommand command = DepartmentCreationCommand.builder()
      .name("Finance")
      .build();

    when(repo.existsByName("Finance"))
      .thenThrow(new DataAccessResourceFailureException("DB error"));

    assertThrows(
      DepartmentDataAccessException.class,
      () -> adapter.validateUniqueness(command)
    );
  }

  @Test
  void shouldValidateExistenceWhenDepartmentExists() {
    when(repo.existsById(1L))
      .thenReturn(true);

    assertDoesNotThrow(() ->
      adapter.validateExistence(1L)
    );
  }

  @Test
  void shouldThrowExceptionWhenDepartmentDoesNotExist() {
    when(repo.existsById(1L))
      .thenReturn(false);

    assertThrows(
      DepartmentNotFoundException.class,
      () -> adapter.validateExistence(1L)
    );
  }

  @Test
  void shouldThrowExceptionWhenDepartmentIdIsNull() {
    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> adapter.validateExistence(null)
    );
  }

  @Test
  void shouldThrowExceptionWhenDepartmentIdIsZero() {
    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> adapter.validateExistence(0L)
    );
  }

  @Test
  void shouldThrowExceptionWhenDepartmentIdIsNegative() {
    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> adapter.validateExistence(-1L)
    );
  }

  @Test
  void shouldThrowDepartmentDataAccessExceptionWhenExistsByIdFails() {
    when(repo.existsById(1L))
      .thenThrow(new DataAccessResourceFailureException("DB error"));

    assertThrows(
      DepartmentDataAccessException.class,
      () -> adapter.validateExistence(1L)
    );
  }
}