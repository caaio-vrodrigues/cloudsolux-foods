package com.cloudsolux.foods.finances_service.domain.expense.model.reading;

public enum ExpenseReadingKey {
  
  FIND_ALL("FIND_ALL");

  public final String key;

  private ExpenseReadingKey(String key) {
    this.key = key;
  }
}