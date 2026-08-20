package com.cloudsolux.foods.global_services.domain.id_control.model;

public enum IdControlKey {

  CATALOG_ID("CATALOG_ID"), 
  DEPARTMENT_ID("DEPARTMENT_ID"),
  EMPLOYEE_ID("EMPLOYEE_ID"), 
  USER_ACCOUNT_ID("USER_ACCOUNT_ID"),
  EXPENSE_ID("EXPENSE_ID"),
  EXPENSE_ITEM_ID("EXPENSE_ITEM_ID");

  public final String key;

  private IdControlKey(String key) {
    this.key = key;
  }
}