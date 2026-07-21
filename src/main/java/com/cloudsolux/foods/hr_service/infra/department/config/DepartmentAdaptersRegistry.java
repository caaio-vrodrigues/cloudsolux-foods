package com.cloudsolux.foods.hr_service.infra.department.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationPort;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistencePort;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;

@Configuration
public class DepartmentAdaptersRegistry {
 
  @Bean
  Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators(
    List<DepartmentValidationPort> validators
  ) {
    if(!(validators instanceof List<?>)) {
      String receivedClassName = validators != null ? 
        validators.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<DepartmentValidationPort>", receivedClassName));
    }
    if(validators.isEmpty()) {
      throw new DepartmentInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("DepartmentValidationPort"));
    }
    return validators.stream().collect(Collectors.toMap(
      DepartmentValidationPort::getKey, 
      Function.identity()
    ));
  }

  @Bean
  Map<DepartmentCreationKey, DepartmentCreationPort> departmentFactories(
    List<DepartmentCreationPort> factories
  ) {
    if(!(factories instanceof List<?>)) {
      String receivedClassName = factories != null ? 
        factories.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<DepartmentCreationPort>", receivedClassName));
    }
    if(factories.isEmpty()) {
      throw new DepartmentInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("DepartmentCreationPort"));
    }
    return factories.stream().collect(Collectors.toMap(
      DepartmentCreationPort::getKey, 
      Function.identity()
    ));
  }

  @Bean
  Map<DepartmentPersistenceKey, DepartmentPersistencePort> departmentPersistences(
    List<DepartmentPersistencePort> persistences
  ) {
    if(!(persistences instanceof List<?>)) {
      String receivedClassName = persistences != null ? 
        persistences.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<DepartmentPersistencePort>", receivedClassName));
    }
    if(persistences.isEmpty()) {
      throw new DepartmentInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("DepartmentPersistencePort"));
    }  
    return persistences.stream().collect(Collectors.toMap(
      DepartmentPersistencePort::getKey, 
      Function.identity()
    ));
  }
}