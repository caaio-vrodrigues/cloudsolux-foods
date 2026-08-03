package com.cloudsolux.foods.hr_service.app.user_account.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.command.UserAccountCreationCommand;

@Service
public class UserAccountCreationHandler {

  @Transactional
  public UserAccount create(UserAccountCreationCommand userAccountCreationCommand, Long userAccountId) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}