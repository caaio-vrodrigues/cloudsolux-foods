package com.cloudsolux.foods.hr_service.infra.employee.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationKey;
import com.cloudsolux.foods.hr_service.domain.employee.model.validation.EmployeeValidationPort;

@Configuration
public class EmployeeAdaptersRegistry {
  
  @Bean
  Map<EmployeeValidationKey, EmployeeValidationPort> employeeValidators(
    List<EmployeeValidationPort> validators
  ) {
    return validators.stream().collect(Collectors.toMap(
      EmployeeValidationPort::getKey, 
      Function.identity())
    );
  }
}