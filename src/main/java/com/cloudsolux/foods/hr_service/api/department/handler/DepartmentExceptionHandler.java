package com.cloudsolux.foods.hr_service.api.department.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentDataAccessException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentNotFoundException;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentPersistenceException;

@Order(1)
@RestControllerAdvice
public final class DepartmentExceptionHandler {
 
  @ExceptionHandler(DepartmentAlreadyExistsException.class)
  public ProblemDetail handleDepartmentAlreadyExists(
    DepartmentAlreadyExistsException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.DUPLICATED_ENTITY_TITLE);
  }

  @ExceptionHandler(DepartmentInvalidArgumentException.class)
  public ProblemDetail handleDepartmentInvalidArgument(
    DepartmentInvalidArgumentException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }

  @ExceptionHandler(DepartmentInvalidDependencyException.class)
  public ProblemDetail handleDepartmentInvalidDependency(
    DepartmentInvalidDependencyException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE);
  }

  @ExceptionHandler(DepartmentPersistenceException.class)
  public ProblemDetail handleDepartmentPersistence(
    DepartmentPersistenceException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE);
  }

  @ExceptionHandler(DepartmentNotFoundException.class)
  public ProblemDetail handleDepartmentNotFound(
    DepartmentNotFoundException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.NOT_FOUND, 
				GlobalMsgCreator.NOT_FOUND_TITLE);
  }

  @ExceptionHandler(DepartmentDataAccessException.class)
  public ProblemDetail handleDepartmentDataAccess(
    DepartmentDataAccessException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.ACCESS_FAILURE_TITLE);
  }
}