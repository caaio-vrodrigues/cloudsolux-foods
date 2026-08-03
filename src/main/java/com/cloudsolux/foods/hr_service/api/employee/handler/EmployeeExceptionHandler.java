package com.cloudsolux.foods.hr_service.api.employee.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeDataAccessException;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeeInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeePersistenceException;

@Order(1)
@RestControllerAdvice
public final class EmployeeExceptionHandler {
  
  @ExceptionHandler(EmployeeAlreadyExistsException.class)
  public ProblemDetail handleEmployeeAlreadyExists(
    EmployeeAlreadyExistsException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.DUPLICATED_ENTITY_TITLE
      );
  }

  @ExceptionHandler(EmployeeDataAccessException.class)
  public ProblemDetail handleEmployeeDataAccess(
    EmployeeDataAccessException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.ACCESS_FAILURE_TITLE
      );
  }

  @ExceptionHandler(EmployeeInvalidArgumentException.class)
  public ProblemDetail handleEmployeeInvalidArgument(
    EmployeeInvalidArgumentException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE
      );
  }

  @ExceptionHandler(EmployeeInvalidDependencyException.class)
  public ProblemDetail handleEmployeeInvalidDependency(
    EmployeeInvalidDependencyException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE
      );
  }

  @ExceptionHandler(EmployeePersistenceException.class)
  public ProblemDetail handleEmployeePersistence(
    EmployeePersistenceException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE
      );
  }
}