package com.cloudsolux.foods.global_services.api.global.handler;

import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.GlobalExceptionResponseCreator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(3)
@RestControllerAdvice
public final class DataBaseExceptionHandler {
  
  @ExceptionHandler(DataAccessException.class)
	public ProblemDetail handleDataAccessException(DataAccessException e) {
		return GlobalExceptionResponseCreator
      .createProblemDetailAndLog(
        e, 
        HttpStatus.INTERNAL_SERVER_ERROR, 
        GlobalMsgCreator.UNEXPECTED_FAILURE_TITLE
      );
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ProblemDetail handleDataIntegrityViolationException(
		DataIntegrityViolationException e
	) {
		return GlobalExceptionResponseCreator
      .createProblemDetailAndLog(
        e, 
        HttpStatus.INTERNAL_SERVER_ERROR, 
        GlobalMsgCreator.UNEXPECTED_FAILURE_TITLE
      );
	}
}