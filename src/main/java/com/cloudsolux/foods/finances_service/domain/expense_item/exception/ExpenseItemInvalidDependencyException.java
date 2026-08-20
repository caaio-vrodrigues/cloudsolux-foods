package com.cloudsolux.foods.finances_service.domain.expense_item.exception;

public final class ExpenseItemInvalidDependencyException extends RuntimeException {
  
  public ExpenseItemInvalidDependencyException(String msg) {
    super(msg);
  }
}