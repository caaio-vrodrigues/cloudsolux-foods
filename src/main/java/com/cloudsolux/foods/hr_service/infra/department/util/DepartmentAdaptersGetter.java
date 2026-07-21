package com.cloudsolux.foods.hr_service.infra.department.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationPort;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistencePort;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentAdaptersGetter {
 
  private final Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators;
  private final Map<DepartmentCreationKey, DepartmentCreationPort> departmentFactories;
  private final Map<DepartmentPersistenceKey, DepartmentPersistencePort> departmentPersistences;

  public DepartmentValidationPort getValidator(DepartmentValidationKey key) {
    if(!(key instanceof DepartmentValidationKey)) {
      String receivedClassName = key != null ? 
        key.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("DepartmentValidationKey", receivedClassName));
    }
    if(!(departmentValidators instanceof Map<?, ?>)) {
      String receivedClassName = departmentValidators != null ? 
        departmentValidators.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg(
          "Map<DepartmentValidationKey, DepartmentValidationPort>", 
          receivedClassName));
    }
    if(departmentValidators.isEmpty()) {
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList(
          "DepartmentValidationPort", 
          "departmentValidators"));
    }
    return departmentValidators.get(key);
  }

  public DepartmentCreationPort getFactory(DepartmentCreationKey key) {
    if(!(key instanceof DepartmentCreationKey)) {
      String receivedClassName = key != null ? 
        key.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("DepartmentCreationKey", receivedClassName));
    }
    if(!(departmentFactories instanceof Map<?, ?>)) {
      String receivedClassName = departmentFactories != null ? 
        departmentFactories.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("Map<DepartmentCreationKey, DepartmentCreationPort>", receivedClassName));
    }
    if(departmentFactories.isEmpty()) {
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator.emptyDependencyList(
        "DepartmentCreationPort", "departmentFactories"));
    }
    return departmentFactories.get(key);
  }

  public DepartmentPersistencePort getPersistence(DepartmentPersistenceKey key) {
    if(!(key instanceof DepartmentPersistenceKey)) {
      String receivedClassName = key != null ? 
        key.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("DepartmentPersistenceKey", receivedClassName));
    }
    if(!(departmentPersistences instanceof Map<?, ?>)) {
      String receivedClassName = departmentPersistences != null ? 
        departmentPersistences.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("Map<DepartmentPersistenceKey, DepartmentPersistencePort>", receivedClassName));
    }
    if(departmentPersistences.isEmpty()) {
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator.emptyDependencyList(
        "DepartmentPersistencePort", "departmentPersistences"));
    }
    return departmentPersistences.get(key);
  }
}