package com.cloudsolux.foods.finances_service.domain.expense.model.creation;

public enum ExpenseCreationKey {

  EXPENSE_CREATION("EXPENSE_CREATION");
  
  public final String key;

  private ExpenseCreationKey(String key) {
    this.key = key;
  }
}