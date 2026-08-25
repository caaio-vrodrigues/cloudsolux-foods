package com.cloudsolux.foods.hr_service.app.employee.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.id_control.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.app.user_account.handler.UserAccountCreationHandler;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreation;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistence;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;
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
    EmployeeValidationAux.validateArgument(employeeCreationCommand, "EmployeeCreationCommand");
    EmployeeValidationAux.validateArgument(userAccountCreationCommand, "UserAccountCreationCommand");

    departmentValidator.validateExistence(employeeCreationCommand.getDepartmentId());

    EmployeeCreation factory = (EmployeeCreation) adapters
      .getFactory(employeeCreationCommand.getFactoryKey());

    EmployeePersistence persistence = (EmployeePersistence) adapters
      .getPersistence(employeeCreationCommand.getPersistenceKey());

    Long userAccountId = idGenerator
      .generateId(userAccountCreationCommand.getUserAccountIdControlKey());

    UserAccount userAccount = userAccountHandler
      .create(userAccountCreationCommand, userAccountId);

    Long employeeId = idGenerator.generateId(employeeCreationCommand.getEmployeeIdControlKey());

    Employee employee = factory.create(
      employeeId, userAccountId, employeeCreationCommand.getDepartmentId());

    persistence.save(employee);

    return responseGenerator.toEmployeeResponse(employee, userAccount);
  }
}