package com.cloudsolux.foods.global_services.api.id_control.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlDataAccessException;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlPersistenceException;
import com.cloudsolux.foods.global_services.infra.global.util.GlobalExceptionResponseCreator;

@Order(1)
@RestControllerAdvice
public final class IdControlExceptionHandler {
  
  @ExceptionHandler(IdControlDataAccessException.class)
  public ProblemDetail handleIdControlAccess(
    IdControlDataAccessException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.ACCESS_FAILURE_TITLE);
  }

  @ExceptionHandler(IdControlPersistenceException.class)
  public ProblemDetail handleIdControlPersistence(
    IdControlPersistenceException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE);
  }

  @ExceptionHandler(IdControlInvalidArgumentException.class)
  public ProblemDetail handleIdControlInvalidArgument(
    IdControlInvalidArgumentException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }
}