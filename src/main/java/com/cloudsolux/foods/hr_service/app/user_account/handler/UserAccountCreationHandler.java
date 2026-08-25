package com.cloudsolux.foods.hr_service.app.user_account.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.command.UserAccountCreationCommand;
import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreation;
import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistence;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidation;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;
import com.cloudsolux.foods.hr_service.infra.user_account.util.UserAccountAdaptersGetter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAccountCreationHandler {

  private final UserAccountAdaptersGetter adapters;

  @Transactional
  public UserAccount create(UserAccountCreationCommand command, Long userAccountId) {
    UserAccountValidationAux.validateArgument(command, "UserAccountCreationCommand");
    UserAccountValidationAux.validatePositive(userAccountId, "userAccountId");

    UserAccountValidation validator = (UserAccountValidation) adapters
      .getValidator(UserAccountValidationKey.USER_ACCOUNT_VALIDATION);

    UserAccountCreation factory = (UserAccountCreation) adapters
      .getFactory(UserAccountCreationKey.USER_ACCOUNT_CREATION);

    UserAccountPersistence persistence = (UserAccountPersistence) adapters
      .getPersistence(UserAccountPersistenceKey.USER_ACCOUNT_PERSISTENCE);

    validator.validateUniqueness(command.getEmail());
    UserAccount userAccount = factory.create(command, userAccountId);
    persistence.save(userAccount);
    return userAccount;
  }
}