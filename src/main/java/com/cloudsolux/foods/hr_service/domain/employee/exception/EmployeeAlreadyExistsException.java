package com.cloudsolux.foods.hr_service.domain.employee.exception;

public final class EmployeeAlreadyExistsException extends RuntimeException {
 
  public EmployeeAlreadyExistsException(String msg) {
    super(msg);
  }
}