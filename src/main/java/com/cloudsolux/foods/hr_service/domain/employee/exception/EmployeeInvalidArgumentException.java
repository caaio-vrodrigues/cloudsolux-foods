package com.cloudsolux.foods.hr_service.domain.employee.exception;

public class EmployeeInvalidArgumentException extends RuntimeException {
 
  public EmployeeInvalidArgumentException(String msg) {
    super(msg);
  }
}