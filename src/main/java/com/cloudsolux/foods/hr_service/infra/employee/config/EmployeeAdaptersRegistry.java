package com.cloudsolux.foods.hr_service.infra.employee.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.creation.EmployeeCreationPort;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistenceKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistencePort;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationPort;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidatorAux;

@Configuration
public class EmployeeAdaptersRegistry {
  
  @Bean
  Map<EmployeeValidationKey, EmployeeValidationPort> employeeValidators(
    List<EmployeeValidationPort> validators
  ) {
    EmployeeValidatorAux.validateRegistryCreation(
      validators, 
      "EmployeeValidationPort"
    );

    return validators.stream().collect(Collectors.toMap(
      EmployeeValidationPort::getKey, 
      Function.identity())
    );
  }

  @Bean
  Map<EmployeeCreationKey, EmployeeCreationPort> employeeFactories(
    List<EmployeeCreationPort> factories
  ) {
    EmployeeValidatorAux.validateRegistryCreation(
      factories, 
      "EmployeeCreationPort"
    );

    return factories.stream().collect(Collectors.toMap(
      EmployeeCreationPort::getKey, 
      Function.identity())
    );
  }

  @Bean
  Map<EmployeePersistenceKey, EmployeePersistencePort> employeePersistences(
    List<EmployeePersistencePort> persistences
  ) {
    EmployeeValidatorAux.validateRegistryCreation(
      persistences, 
      "EmployeePersistencePort"
    );

    return persistences.stream().collect(Collectors.toMap(
      EmployeePersistencePort::getKey, 
      Function.identity())
    );
  }
}