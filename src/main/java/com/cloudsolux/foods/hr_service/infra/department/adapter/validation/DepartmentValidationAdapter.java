package com.cloudsolux.foods.hr_service.infra.department.adapter.validation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentMsgCreator;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentValidationAdapter implements DepartmentValidation {

  private final DepartmentRepo repo;
  
  @Override
  public DepartmentValidationKey getKey() {
    return DepartmentValidationKey.VALIDATE_CREATION;
  }

  @Override
  public void validateUniqueness(DepartmentCreationCommand command) {
    if(command == null) {
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("DepartmentEntity", "DepartmentCreationCommand"));
    }
    if(repo.existsByName(command.getName())) {
      throw new DepartmentAlreadyExistsException(DepartmentMsgCreator
        .uniquenessViolationMsg(command.getName()));
    }
  }
}