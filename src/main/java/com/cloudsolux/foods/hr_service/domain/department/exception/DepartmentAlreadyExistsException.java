package com.cloudsolux.foods.hr_service.domain.department.exception;

public class DepartmentAlreadyExistsException extends RuntimeException {
 
  public DepartmentAlreadyExistsException(String msg) {
    super(msg);
  }
}