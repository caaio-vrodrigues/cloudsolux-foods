package com.cloudsolux.foods.finances_service.api.expense.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpenseInvalidArgumentException;
import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpenseInvalidDependencyException;
import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpensePersistenceException;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;

@Order(1)
@RestControllerAdvice
public final class ExpenseExceptionHandler {
 
  @ExceptionHandler(ExpenseInvalidArgumentException.class)
  public ProblemDetail handleExpenseInvalidArgument(
    ExpenseInvalidArgumentException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e, 
      HttpStatus.BAD_REQUEST, 
      GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }

  @ExceptionHandler(ExpenseInvalidDependencyException.class)
  public ProblemDetail handleExpenseInvalidDependency(
    ExpenseInvalidDependencyException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e, 
      HttpStatus.INTERNAL_SERVER_ERROR, 
      GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE);
  }

  @ExceptionHandler(ExpensePersistenceException.class)
  public ProblemDetail handleExpensePersistence(
    ExpensePersistenceException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e, 
      HttpStatus.INTERNAL_SERVER_ERROR, 
      GlobalMsgCreator.PERSISTENCE_FAILURE_TITLE);
  }
}