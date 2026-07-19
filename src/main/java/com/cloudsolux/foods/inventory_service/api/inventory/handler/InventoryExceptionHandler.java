package com.cloudsolux.foods.inventory_service.api.inventory.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.GlobalExceptionResponseCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryConcurrentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;

@Order(1)
@RestControllerAdvice
public class InventoryExceptionHandler {
 
  @ExceptionHandler(InventoryConcurrentException.class)
  public ProblemDetail handleInventoryConcurrent(
    InventoryConcurrentException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.CONCURRENCY_TITLE);
  }

  @ExceptionHandler(InventoryInvalidArgumentException.class)
  public ProblemDetail handleInventoryInvalidArgument(
    InventoryInvalidArgumentException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }
}