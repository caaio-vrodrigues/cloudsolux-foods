package com.cloudsolux.foods.hr_service.domain.user_account.exception;

public final class UserAccountAlreadyExistsException extends RuntimeException {
  
  public UserAccountAlreadyExistsException(String msg) {
    super(msg);
  }
}