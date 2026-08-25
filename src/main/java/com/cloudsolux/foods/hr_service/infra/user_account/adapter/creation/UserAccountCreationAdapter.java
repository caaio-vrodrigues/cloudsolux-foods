package com.cloudsolux.foods.hr_service.infra.user_account.adapter.creation;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.command.UserAccountCreationCommand;
import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreation;
import com.cloudsolux.foods.hr_service.domain.user_account.model.creation.UserAccountCreationKey;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class UserAccountCreationAdapter implements UserAccountCreation {

  private final PasswordEncoder passwordEncoder;

  @Override
  public UserAccountCreationKey getKey() {
    return UserAccountCreationKey.USER_ACCOUNT_CREATION;
  }

  @Override
  public UserAccount create(UserAccountCreationCommand command, Long id) {
    UserAccountValidationAux.validateArgument(command, "UserAccountCreationCommand");
    UserAccountValidationAux.validatePositive(id, "id");
    
    return UserAccount.builder()
      .id(id)
      .firstName(command.getFirstName())
      .lastName(command.getLastName())
      .birthday(command.getBirthday())
      .role(command.getRole())
      .email(command.getEmail())
      .password(passwordEncoder.encode(command.getPassword()))
      .active(command.getActive())
      .build();
  }
}