package com.cloudsolux.foods.hr_service.app.department.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.util.IdGenerator;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentAdaptersGetter;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentResponseGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentCreationHandler {

  private final DepartmentAdaptersGetter adapters;
  private final DepartmentResponseGenerator responseGenerator;
  private final IdGenerator idGenerator;

  @Transactional
  public DepartmentResponse create(DepartmentCreationCommand command) {
    DepartmentValidation validator = (DepartmentValidation) adapters
      .getValidator(command.getValidationKey());
    validator.validateUniqueness(command);

    Long id = idGenerator.getId(IdControlKey.DEPARTMENT_ID);

    DepartmentCreation factory = (DepartmentCreation) adapters
      .getFactory(command.getFactoryKey());
    Department department = factory.create(command, id);

    DepartmentPersistence persistence = (DepartmentPersistence) adapters
      .getPersistence(command.getPersistenceKey());
    persistence.saveDepartment(department);

    return responseGenerator.toDepartmentResponse(department);
  }
}