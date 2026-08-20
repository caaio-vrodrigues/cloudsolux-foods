package com.cloudsolux.foods.finances_service.domain.expense.exception;

public final class ExpensePersistenceException extends RuntimeException {
 
  public ExpensePersistenceException(String msg) {
    super(msg);
  }
}