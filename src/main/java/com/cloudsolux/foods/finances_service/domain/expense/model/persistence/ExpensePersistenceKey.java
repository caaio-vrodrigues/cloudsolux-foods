package com.cloudsolux.foods.finances_service.domain.expense.model.persistence;

public enum ExpensePersistenceKey {

  EXPENSE_PERSISTENCE("EXPENSE_PERSISTENCE");

  public final String key;
  
  private ExpensePersistenceKey(String key) {
    this.key = key;
  }
}