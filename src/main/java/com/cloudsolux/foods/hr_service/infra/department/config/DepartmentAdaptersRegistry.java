package com.cloudsolux.foods.hr_service.infra.department.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreationPort;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistencePort;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

@Configuration
public class DepartmentAdaptersRegistry {
 
  @Bean
  Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators(
    List<DepartmentValidationPort> validators
  ) {
    DepartmentValidationAux.validateRegistryCreation(
      validators, "DepartmentValidationPort");

    return validators.stream().collect(Collectors.toMap(
      DepartmentValidationPort::getKey, 
      Function.identity()
    ));
  }

  @Bean
  Map<DepartmentCreationKey, DepartmentCreationPort> departmentFactories(
    List<DepartmentCreationPort> factories
  ) {
    DepartmentValidationAux.validateRegistryCreation(
      factories, "DepartmentCreationPort");

    return factories.stream().collect(Collectors.toMap(
      DepartmentCreationPort::getKey, 
      Function.identity()
    ));
  }

  @Bean
  Map<DepartmentPersistenceKey, DepartmentPersistencePort> departmentPersistences(
    List<DepartmentPersistencePort> persistences
  ) {
    DepartmentValidationAux.validateRegistryCreation(
      persistences, "DepartmentPersistencePort");

    return persistences.stream().collect(Collectors.toMap(
      DepartmentPersistencePort::getKey, 
      Function.identity()
    ));
  }
}