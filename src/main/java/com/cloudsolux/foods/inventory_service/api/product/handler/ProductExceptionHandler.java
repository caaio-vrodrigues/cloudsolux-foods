package com.cloudsolux.foods.inventory_service.api.product.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductAlreadyExistsException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductDataAccessException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductPersistenceException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidDependencyException;

@Order(1)
@RestControllerAdvice
public final class ProductExceptionHandler {
  
  @ExceptionHandler(ProductAlreadyExistsException.class)
  public ProblemDetail handleProductAlreadyExists(
    ProductAlreadyExistsException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.CONFLICT, 
				GlobalMsgCreator.DUPLICATED_ENTITY_TITLE);
  }

  @ExceptionHandler(ProductPersistenceException.class)
  public ProblemDetail handleProductConcurrent(
    ProductPersistenceException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE);
  }

  @ExceptionHandler(ProductInvalidArgumentException.class)
  public ProblemDetail handleProductInvalidArgument(
    ProductInvalidArgumentException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }

  @ExceptionHandler(ProductDataAccessException.class)
  public ProblemDetail handleProductDataAccess(
    ProductDataAccessException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.ACCESS_FAILURE_TITLE);
  }

  @ExceptionHandler(ProductInvalidDependencyException.class)
  public ProblemDetail handleProductInvalidDependency(
    ProductInvalidDependencyException e
  ) {
    return ExceptionResponseCreator
			.createProblemDetailAndLog(
				e, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE);
  }
}