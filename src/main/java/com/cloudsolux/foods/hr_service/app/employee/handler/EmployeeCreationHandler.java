package com.cloudsolux.foods.hr_service.app.employee.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreation;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistence;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidation;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;
import com.cloudsolux.foods.hr_service.infra.employee.util.EmployeeAdaptersGetter;
import com.cloudsolux.foods.hr_service.infra.employee.util.EmployeeResponseGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeCreationHandler {

  private final EmployeeAdaptersGetter adapters;
  private final IdControlGeneratorHandler idGenerator;
  private final EmployeeResponseGenerator responseGenerator;
  private final DepartmentValidation departmentValidator;
  
  @Transactional
  public EmployeeResponse create(EmployeeCreationCommand command) {
    EmployeeValidatorAux.validateArgument(command, "EmployeeCreationCommand");
    EmployeeValidatorAux.validateDependency(adapters, "EmployeeAdaptersGetter");
    EmployeeValidatorAux.validateDependency(idGenerator, "IdControlGeneratorHandler");
    EmployeeValidatorAux.validateDependency(responseGenerator, "EmployeeResponseGenerator");
    EmployeeValidatorAux.validateDependency(departmentValidator, "DepartmentValidationAdapter");

    EmployeeValidation validator = (EmployeeValidation) adapters
      .getValidator(command.getValidationKey());
    
    EmployeeValidatorAux.validateDependency(validator, "EmployeeAdaptersGetter");
    validator.validateUniqueness(command.getEmail());

    departmentValidator.validateExistence(command.getDepartmentId());

    Long id = idGenerator.generateId(command.getIdControlKey());

    EmployeeCreation factory = (EmployeeCreation) adapters
      .getFactories(command.getFactoryKey());

    EmployeeValidatorAux.validateDependency(factory, "EmployeeAdaptersGetter");
    Employee employee = factory.create(command, id);

    EmployeePersistence persistence = (EmployeePersistence) adapters
      .getPersistences(command.getPersistenceKey());

    EmployeeValidatorAux.validateDependency(persistence, "EmployeeAdaptersGetter");
    persistence.save(employee);

    return responseGenerator.toEmployeeResponse(employee);
  }
}