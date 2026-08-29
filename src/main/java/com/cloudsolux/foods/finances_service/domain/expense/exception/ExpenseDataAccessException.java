package com.cloudsolux.foods.finances_service.domain.expense.exception;

public final class ExpenseDataAccessException extends RuntimeException {
 
  public ExpenseDataAccessException(String msg) {
    super(msg);
  }
}