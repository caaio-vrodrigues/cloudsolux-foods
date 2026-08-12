package com.cloudsolux.foods.hr_service.domain.department.exception;

public final class DepartmentNotFoundException extends RuntimeException {
 
  public DepartmentNotFoundException(String msg) {
    super(msg);
  }
}