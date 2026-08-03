package com.cloudsolux.foods.hr_service.domain.user_account.model.persistence;

public enum UserAccountPersistenceKey {

  USER_ACCOUNT_PERSISTENCE("USER_ACCOUNT_PERSISTENCE");

  public final String key;
 
  private UserAccountPersistenceKey(String key) {
    this.key = key;
  }
}