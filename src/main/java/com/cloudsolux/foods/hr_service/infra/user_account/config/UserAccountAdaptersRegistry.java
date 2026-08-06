package com.cloudsolux.foods.hr_service.infra.user_account.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreationPort;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistencePort;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.model.validation.UserAccountValidationPort;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;

@Configuration
public class UserAccountAdaptersRegistry {
 
  @Bean
  Map<UserAccountValidationKey, UserAccountValidationPort> userAccountValidators(
    List<UserAccountValidationPort> validators
  ) {
    UserAccountValidationAux.validateRegistryCreation(validators, "UserAccountValidationPort");

    return validators.stream().collect(Collectors.toMap(
      UserAccountValidationPort::getKey, 
      Function.identity())
    );
  }

  @Bean
  Map<UserAccountCreationKey, UserAccountCreationPort> userAccountFactories(
    List<UserAccountCreationPort> factories
  ) {
    UserAccountValidationAux.validateRegistryCreation(factories, "UserAccountCreationPort");

    return factories.stream().collect(Collectors.toMap(
      UserAccountCreationPort::getKey, 
      Function.identity())
    );
  }

  @Bean
  Map<UserAccountPersistenceKey, UserAccountPersistencePort> userAccountPersistences(
    List<UserAccountPersistencePort> persistences
  ) {
    UserAccountValidationAux.validateRegistryCreation(persistences, "UserAccountPersistencePort");

    return persistences.stream().collect(Collectors.toMap(
      UserAccountPersistencePort::getKey, 
      Function.identity())
    );
  }
}