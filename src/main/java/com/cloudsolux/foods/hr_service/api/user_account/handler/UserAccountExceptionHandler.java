package com.cloudsolux.foods.hr_service.api.user_account.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountAlreadyExistsException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountDataAccessException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidArgumentException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountPersistenceException;

@Order(1)
@RestControllerAdvice
public class UserAccountExceptionHandler {

  @ExceptionHandler(UserAccountAlreadyExistsException.class)
  public ProblemDetail handleUserAccountAlreadyExists(
    UserAccountAlreadyExistsException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.DUPLICATED_ENTITY_TITLE
      );
  }

  @ExceptionHandler(UserAccountDataAccessException.class)
  public ProblemDetail handleUserAccountDataAccess(
    UserAccountDataAccessException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.ACCESS_FAILURE_TITLE
      );
  }

  @ExceptionHandler(UserAccountInvalidArgumentException.class)
  public ProblemDetail handleUserAccountInvalidArgument(
    UserAccountInvalidArgumentException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE
      );
  }

  @ExceptionHandler(UserAccountInvalidDependencyException.class)
  public ProblemDetail handleUserAccountInvalidDependency(
    UserAccountInvalidDependencyException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE
      );
  }

  @ExceptionHandler(UserAccountPersistenceException.class)
  public ProblemDetail handleUserAccountPersistence(
    UserAccountPersistenceException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE
      );
  }
}