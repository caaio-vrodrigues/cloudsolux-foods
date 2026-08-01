package com.cloudsolux.foods.hr_service.domain.employee.model.persistence;

public enum EmployeePersistenceKey {
 
  EMPLOYEE_PERSISTENCE("EMPLOYEE_PERSISTENCE");

  public final String key;

  private EmployeePersistenceKey(String key) {
    this.key = key;
  }
}