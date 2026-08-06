package com.cloudsolux.foods.hr_service.infra.user_account.adapter.validation;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountDataAccessException;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidation;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;
import com.cloudsolux.foods.hr_service.infra.user_account.repo.UserAccountRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class UserAccountValidationAdapter implements UserAccountValidation {

  private final UserAccountRepo repo;

  @Override
  public UserAccountValidationKey getKey() {
    return UserAccountValidationKey.USER_ACCOUNT_VALIDATION;
  }

  @Override
  public void validateUniqueness(String email) {
    UserAccountValidationAux.validateEmail(email, "email");
    UserAccountValidationAux.validateDependency(repo, "UserAccountRepo");

    Boolean existsByEmail;

    try{
      existsByEmail = repo.existsByEmail(email);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("UserAccount")+". {}", 
        e.getMessage(), 
        e
      );
      throw new UserAccountDataAccessException(GlobalMsgCreator
        .accessFailureMsg("UserAccount"));
    }

    UserAccountValidationAux.validateUniqueness(existsByEmail, email);
  }
}