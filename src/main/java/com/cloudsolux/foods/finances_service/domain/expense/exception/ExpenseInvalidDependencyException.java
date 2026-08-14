package com.cloudsolux.foods.finances_service.domain.expense.exception;

public final class ExpenseInvalidDependencyException extends RuntimeException {
  
  public ExpenseInvalidDependencyException(String msg) {
    super(msg);
  }
}