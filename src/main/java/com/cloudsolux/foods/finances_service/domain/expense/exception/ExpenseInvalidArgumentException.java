package com.cloudsolux.foods.finances_service.domain.expense.exception;

public final class ExpenseInvalidArgumentException extends RuntimeException {
  
  public ExpenseInvalidArgumentException(String msg) {
    super(msg);
  }
}