package com.cloudsolux.foods.finances_service.domain.expense_item.model.validation;

public enum ExpenseItemValidationKey {
 
  EXPENSE_ITEM_CREATION_VALIDATION("EXPENSE_ITEM_CREATION_VALIDATION");

  public final String key;

  private ExpenseItemValidationKey(String key) {
    this.key = key;
  }
}