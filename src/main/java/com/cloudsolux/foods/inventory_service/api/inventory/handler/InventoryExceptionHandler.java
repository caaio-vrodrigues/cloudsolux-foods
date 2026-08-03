package com.cloudsolux.foods.inventory_service.api.inventory.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryPersistenceException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidDependencyException;

@Order(1)
@RestControllerAdvice
public final class InventoryExceptionHandler {
 
  @ExceptionHandler(InventoryPersistenceException.class)
  public ProblemDetail handleInventoryPersistence(
    InventoryPersistenceException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE);
  }

  @ExceptionHandler(InventoryInvalidArgumentException.class)
  public ProblemDetail handleInventoryInvalidArgument(
    InventoryInvalidArgumentException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }

  @ExceptionHandler(InventoryInvalidDependencyException.class)
  public ProblemDetail handleInventoryInvalidDependency(
    InventoryInvalidDependencyException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE);
  }
}