package com.cloudsolux.foods.hr_service.domain.department.exception;

public class DepartmentNotFoundException extends RuntimeException {
 
  public DepartmentNotFoundException(String msg) {
    super(msg);
  }
}