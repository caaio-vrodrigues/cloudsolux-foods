package com.cloudsolux.foods.hr_service.domain.department.model.validation;

public enum DepartmentValidationKey {

  VALIDATE_CREATION("VALIDATE_CREATION");

  public final String key;
  
  private DepartmentValidationKey(String key) {
    this.key = key;
  }
}