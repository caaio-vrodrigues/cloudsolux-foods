package com.cloudsolux.foods.hr_service.domain.user_account.model.creation;

import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.command.UserAccountCreationCommand;

public interface UserAccountCreation extends UserAccountCreationPort {
 
  UserAccount create(UserAccountCreationCommand command, Long id);
}