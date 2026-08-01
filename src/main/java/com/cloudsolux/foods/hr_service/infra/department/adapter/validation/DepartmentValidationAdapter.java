package com.cloudsolux.foods.hr_service.infra.department.adapter.validation;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentDataAccessException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentNotFoundException;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class DepartmentValidationAdapter implements DepartmentValidation {

  private final DepartmentRepo repo;
  
  @Override
  public DepartmentValidationKey getKey() {
    return DepartmentValidationKey.VALIDATE_CREATION;
  }

  @Override
  public void validateUniqueness(DepartmentCreationCommand command) {
    DepartmentValidationAux.validateArgument(command, "DepartmentCreationCommand");
    DepartmentValidationAux.validateDependency(repo, "DepartmentRepo");

    boolean existsByName;
   
    try {
      existsByName = repo.existsByName(command.getName());
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("Department")+" {}",
        e.getMessage(), 
        e
      );
      throw new DepartmentDataAccessException(GlobalMsgCreator
        .accessFailureMsg("Department"));
    }

    DepartmentValidationAux.validateDependency(existsByName, "DepartmentRepo");

    if(existsByName)
      throw new DepartmentAlreadyExistsException(DepartmentMsgCreator
        .uniquenessViolationMsg(command.getName()));
  }

  @Override
  public void validateExistence(Long departmentId) {
    DepartmentValidationAux.validatePositiveLong(departmentId, "departmentId");
    DepartmentValidationAux.validateDependency(repo, "DepartmentRepo");

    if(!repo.existsById(departmentId)) 
      throw new DepartmentNotFoundException(GlobalMsgCreator
        .notFoundMsg("Department", departmentId));
  }
}