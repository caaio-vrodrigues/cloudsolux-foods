package com.cloudsolux.foods.hr_service.app.department.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
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
    DepartmentValidationAux
      .validateArgument(command, "DepartmentCreationCommand");
    DepartmentValidationAux
      .validateDependency(adapters, "DepartmentAdaptersGetter");
    DepartmentValidationAux
      .validateDependency(idGeneration, "IdControlGeneratorHandler");
    DepartmentValidationAux
      .validateDependency(responseGenerator, "DepartmentResponseGenerator");

    DepartmentValidation validator = (DepartmentValidation) adapters
      .getValidator(command.getValidationKey());
    DepartmentValidationAux.validateDependency(
      validator, "DepartmentAdaptersGetter");

    validator.validateUniqueness(command);

    Long id = idGeneration.generateId(command.getIdGenerationKey());

    DepartmentCreation factory = (DepartmentCreation) adapters
      .getFactory(command.getFactoryKey());
    DepartmentValidationAux.validateDependency(
      factory, "DepartmentAdaptersGetter");

    Department department = factory.create(command, id);

    DepartmentPersistence persistence = (DepartmentPersistence) adapters
      .getPersistence(command.getPersistenceKey());
    DepartmentValidationAux.validateDependency(
      persistence, "DepartmentAdaptersGetter");

    persistence.save(department);

    return responseGenerator.toDepartmentResponse(department);
  }
}