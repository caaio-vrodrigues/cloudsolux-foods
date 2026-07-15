package com.cloudsolux.foods.hr_service.domain.department.exception;

public class DepartmentInvalidArgumentException extends RuntimeException {
 
  public DepartmentInvalidArgumentException(String msg) {
    super(msg);
  }
}