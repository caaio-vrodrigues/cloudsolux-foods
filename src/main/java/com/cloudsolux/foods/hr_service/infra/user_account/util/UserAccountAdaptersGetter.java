package com.cloudsolux.foods.hr_service.infra.user_account.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreationPort;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistencePort;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidationPort;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class UserAccountAdaptersGetter {
  
  private final Map<UserAccountValidationKey, UserAccountValidationPort> userAccountValidators;
  private final Map<UserAccountCreationKey, UserAccountCreationPort> userAccountFactories;
  private final Map<UserAccountPersistenceKey, UserAccountPersistencePort> userAccountPersistences;

  public UserAccountValidationPort getValidator(UserAccountValidationKey key) {
    UserAccountValidationAux.validateArgument(key, "UserAccountValidationKey");

    UserAccountValidationAux.validateDependencyMap(
      userAccountValidators, 
      "Map<UserAccountValidationKey, UserAccountValidationPort>");

    UserAccountValidationPort validator = userAccountValidators.get(key);

    UserAccountValidationAux.validateDependencyResult(
      validator, 
      "userAccountValidators", 
      "UserAccountValidationPort");

    return validator;
  }

  public UserAccountCreationPort getFactory(UserAccountCreationKey key) {
    UserAccountValidationAux.validateArgument(key, "UserAccountCreationKey");

    UserAccountValidationAux.validateDependencyMap(
      userAccountFactories, 
      "Map<UserAccountCreationKey, UserAccountCreationPort>");

    UserAccountCreationPort factory = userAccountFactories.get(key);

    UserAccountValidationAux.validateDependencyResult(
      factory, 
      "userAccountFactories", 
      "UserAccountCreationPort");

    return factory;
  }

  public UserAccountPersistencePort getPersistence(UserAccountPersistenceKey key) {
    UserAccountValidationAux.validateArgument(key, "UserAccountPersistenceKey");

    UserAccountValidationAux.validateDependencyMap(
      userAccountPersistences, 
      "Map<UserAccountPersistenceKey, UserAccountPersistencePort>");

    UserAccountPersistencePort persistence = userAccountPersistences.get(key);

    UserAccountValidationAux.validateDependencyResult(
      persistence, 
      "userAccountPersistences", 
      "UserAccountPersistencePort");

    return persistence;
  }
}