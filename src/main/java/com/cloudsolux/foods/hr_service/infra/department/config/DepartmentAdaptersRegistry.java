package com.cloudsolux.foods.hr_service.infra.department.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;

@Configuration
public class DepartmentAdaptersRegistry {
 
  @Bean
  public Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators(
    List<DepartmentValidationPort> validators
  ) {
    return validators.stream().collect(Collectors.toMap(
      DepartmentValidationPort::getKey, 
      Function.identity()
    ));
  }
}