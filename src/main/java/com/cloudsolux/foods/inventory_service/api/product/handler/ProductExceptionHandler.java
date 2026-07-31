package com.cloudsolux.foods.inventory_service.api.product.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.GlobalExceptionResponseCreator;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductAlreadyExistsException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductPersistenceException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;

@Order(1)
@RestControllerAdvice
public final class ProductExceptionHandler {
  
  @ExceptionHandler(ProductAlreadyExistsException.class)
  public ProblemDetail handleProductAlreadyExists(
    ProductAlreadyExistsException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.DUPLICATED_ENTITY_TITLE);
  }

  @ExceptionHandler(ProductPersistenceException.class)
  public ProblemDetail handleProductConcurrent(
    ProductPersistenceException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.CONCURRENCY_TITLE);
  }

  @ExceptionHandler(ProductInvalidArgumentException.class)
  public ProblemDetail handleProductInvalidArgument(
    ProductInvalidArgumentException e
  ) {
    return GlobalExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }
}