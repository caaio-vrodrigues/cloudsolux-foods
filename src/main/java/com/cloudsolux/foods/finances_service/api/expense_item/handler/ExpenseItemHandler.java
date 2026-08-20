package com.cloudsolux.foods.finances_service.api.expense_item.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidArgumentException;
import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidDependencyException;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;

@Order(1)
@RestControllerAdvice
public final class ExpenseItemHandler {
 
  @ExceptionHandler(ExpenseItemInvalidArgumentException.class)
  public ProblemDetail handleExpenseItemInvalidArgument(
    ExpenseItemInvalidArgumentException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e, 
      HttpStatus.BAD_REQUEST, 
      GlobalMsgCreator.INVALID_ARGUMENT_TITLE);
  }

  @ExceptionHandler(ExpenseItemInvalidDependencyException.class)
  public ProblemDetail handleExpenseItemInvalidDependency(
    ExpenseItemInvalidDependencyException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e, 
      HttpStatus.INTERNAL_SERVER_ERROR, 
      GlobalMsgCreator.DEPENDENCY_FAILURE_TITLE);
  }
}