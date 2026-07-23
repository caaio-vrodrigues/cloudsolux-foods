package com.cloudsolux.foods.hr_service.infra.department.adapter.validation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;

import lombok.RequiredArgsConstructor;

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
    if(repo.existsByName(command.getName()))
      throw new DepartmentAlreadyExistsException(DepartmentMsgCreator
        .uniquenessViolationMsg(command.getName()));
  }
}