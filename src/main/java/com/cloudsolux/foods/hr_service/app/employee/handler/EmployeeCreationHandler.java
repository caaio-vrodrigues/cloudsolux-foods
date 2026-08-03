package com.cloudsolux.foods.hr_service.app.employee.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.app.user_account.handler.UserAccountCreationHandler;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreation;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistence;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;
import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.command.UserAccountCreationCommand;
import com.cloudsolux.foods.hr_service.infra.employee.util.EmployeeAdaptersGetter;
import com.cloudsolux.foods.hr_service.infra.employee.util.EmployeeResponseGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeCreationHandler {

  private final EmployeeAdaptersGetter adapters;
  private final IdControlGeneratorHandler idGenerator;
  private final DepartmentValidation departmentValidator;
  private final UserAccountCreationHandler userAccountHandler;
  private final EmployeeResponseGenerator responseGenerator;
  
  @Transactional
  public EmployeeResponse create(
    EmployeeCreationCommand employeeCreationCommand, 
    UserAccountCreationCommand userAccountCreationCommand
  ) {
    EmployeeValidatorAux.validateArgument(userAccountCreationCommand, "UserAccountCreationCommand");
    EmployeeValidatorAux.validateDependency(userAccountHandler, "UserAccountCreationHandler");
    EmployeeValidatorAux.validateDependency(idGenerator, "IdControlGeneratorHandler");

    Long userAccountId = idGenerator
      .generateId(userAccountCreationCommand.getUserAccountIdControlKey());

    UserAccount userAccount = userAccountHandler
      .create(userAccountCreationCommand, userAccountId);

    EmployeeValidatorAux.validateArgument(employeeCreationCommand, "EmployeeCreationCommand");
    EmployeeValidatorAux.validateDependency(adapters, "EmployeeAdaptersGetter");
    EmployeeValidatorAux.validateDependency(departmentValidator, "DepartmentValidationAdapter");
    EmployeeValidatorAux.validateDependency(responseGenerator, "EmployeeResponseGenerator");

    Long employeeId = idGenerator
      .generateId(employeeCreationCommand.getEmployeeIdControlKey());

    EmployeeCreation factory = (EmployeeCreation) adapters
      .getFactories(employeeCreationCommand.getFactoryKey());
    EmployeeValidatorAux.validateDependency(factory, "EmployeeAdaptersGetter");

    departmentValidator.validateExistence(employeeCreationCommand.getDepartmentId());

    Employee employee = factory.create(
      employeeId, userAccountId, employeeCreationCommand.getDepartmentId()
    );

    EmployeePersistence persistence = (EmployeePersistence) adapters
      .getPersistences(employeeCreationCommand.getPersistenceKey());
    EmployeeValidatorAux.validateDependency(persistence, "EmployeeAdaptersGetter");

    persistence.save(employee);

    return responseGenerator.toEmployeeResponse(employee, userAccount);
  }
}