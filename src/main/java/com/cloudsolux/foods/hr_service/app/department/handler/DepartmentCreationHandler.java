package com.cloudsolux.foods.hr_service.app.department.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.id_control.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentAdaptersGetter;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentResponseGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentCreationHandler {

  private final DepartmentAdaptersGetter adapters;
  private final IdControlGeneratorHandler idGeneration;
  private final DepartmentResponseGenerator responseGenerator;

  @Transactional
  public DepartmentResponse create(DepartmentCreationCommand command) {
    DepartmentValidationAux.validateArgument(command, "DepartmentCreationCommand");

    DepartmentValidation validator = (DepartmentValidation) adapters
      .getValidator(DepartmentValidationKey.VALIDATE_CREATION);

    DepartmentCreation factory = (DepartmentCreation) adapters
      .getFactory(DepartmentCreationKey.DEPARTMENT_CREATION);

    DepartmentPersistence persistence = (DepartmentPersistence) adapters
      .getPersistence(DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE);

    validator.validateUniqueness(command);
    Long id = idGeneration.generateId(IdControlKey.DEPARTMENT_ID);
    Department department = factory.create(command, id);
    persistence.save(department);
    return responseGenerator.toDepartmentResponse(department);
  }
}