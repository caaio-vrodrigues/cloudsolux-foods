package com.cloudsolux.foods.hr_service.infra.employee.adapter.validation;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeDataAccessException;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidation;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationKey;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeMsgCreator;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;
import com.cloudsolux.foods.hr_service.infra.employee.repo.EmployeeRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class EmployeeValidationAdapter implements EmployeeValidation {

  private final EmployeeRepo repo;

  @Override
  public EmployeeValidationKey getKey() {
    return EmployeeValidationKey.EMPLOYEE_VALIDATION;
  }

  @Override
  public void validateUniqueness(String email) {
    EmployeeValidatorAux.validateEmail(email, "email");
    EmployeeValidatorAux.validateDependency(repo, "EmployeeRepo");

    boolean existsByEmail;

    try{
      existsByEmail = repo.existsByEmail(email);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("Employee")+". {}", 
        e.getMessage(), 
        e
      );
      throw new EmployeeDataAccessException(GlobalMsgCreator
        .accessFailureMsg("Employee"));
    }

    EmployeeValidatorAux.validateDependency(existsByEmail, "EmployeeRepo");

    if(existsByEmail) 
      throw new EmployeeAlreadyExistsException(EmployeeMsgCreator
        .uniquenessViolationMsg(email));
  }
}