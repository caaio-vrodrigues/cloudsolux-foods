package com.cloudsolux.foods.hr_service.infra.department.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationKey;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentAdaptersGetter {
 
  private final Map<DepartmentValidationKey, DepartmentValidationPort> departmentValidators;

  public DepartmentValidationPort getValidator(DepartmentValidationKey key) {
    return departmentValidators.get(key);
  }
}