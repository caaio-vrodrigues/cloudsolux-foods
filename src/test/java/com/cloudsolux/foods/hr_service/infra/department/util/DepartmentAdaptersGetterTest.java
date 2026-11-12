package com.cloudsolux.foods.hr_service.infra.department.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationPort;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistencePort;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;

@ExtendWith(MockitoExtension.class)
class DepartmentAdaptersGetterTest {

  @Mock
  private DepartmentValidationPort validationPort;
  @Mock
  private DepartmentValidationKey validationKey;

  @Mock
  private DepartmentCreationPort creationPort;
  @Mock
  private DepartmentCreationKey creationKey;

  @Mock
  private DepartmentPersistencePort persistencePort;
  @Mock
  private DepartmentPersistenceKey persistenceKey;

  @Test
  void shouldReturnValidator() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(validationKey, validationPort),
      Map.of(),
      Map.of()
    );

    DepartmentValidationPort validator = getter.getValidator(validationKey);

    assertEquals(validationPort, validator);
  }

  @Test
  void shouldReturnFactory() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(creationKey, creationPort),
      Map.of()
    );

    DepartmentCreationPort creator = getter.getFactory(creationKey);

    assertEquals(creationPort, creator);
  }

  @Test
  void shouldReturnPersistence() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of(persistenceKey, persistencePort)
    );

    DepartmentPersistencePort persistence = getter.getPersistence(persistenceKey);

    assertEquals(persistencePort, persistence);
  }

  @Test
  void shouldThrowWhenValidatorKeyIsNull() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of()
    );

    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> getter.getValidator(null)
    );
  }

  @Test
  void shouldThrowWhenFactoryKeyIsNull() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of()
    );

    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> getter.getFactory(null)
    );
  }

  @Test
  void shouldThrowWhenPersistenceKeyIsNull() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of()
    );

    assertThrows(
      DepartmentInvalidArgumentException.class,
      () -> getter.getPersistence(null)
    );
  }

  @Test
  void shouldThrowWhenValidatorNotFound() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of()
    );

    assertThrows(
      DepartmentInvalidDependencyException.class,
      () -> getter.getValidator(validationKey)
    );
  }

  @Test
  void shouldThrowWhenFactoryNotFound() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of()
    );

    assertThrows(
      DepartmentInvalidDependencyException.class,
      () -> getter.getFactory(creationKey)
    );
  }

  @Test
  void shouldThrowWhenPersistenceNotFound() {
    DepartmentAdaptersGetter getter = new DepartmentAdaptersGetter(
      Map.of(),
      Map.of(),
      Map.of()
    );

    assertThrows(
      DepartmentInvalidDependencyException.class,
      () -> getter.getPersistence(persistenceKey)
    );
  }
}