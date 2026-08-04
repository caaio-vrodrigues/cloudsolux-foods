package com.cloudsolux.foods.finances_service.domain.expense_item.exception;

public final class ExpenseItemInvalidArgumentException extends RuntimeException {
 
  public ExpenseItemInvalidArgumentException(String msg) {
    super(msg);
  }
}