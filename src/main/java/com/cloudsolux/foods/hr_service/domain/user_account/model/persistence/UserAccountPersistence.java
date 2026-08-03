package com.cloudsolux.foods.hr_service.domain.user_account.model.persistence;

import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;

public interface UserAccountPersistence extends UserAccountPersistencePort {
 
  void save(UserAccount domain);
}