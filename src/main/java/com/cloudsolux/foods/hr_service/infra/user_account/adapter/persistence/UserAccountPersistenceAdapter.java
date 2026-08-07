package com.cloudsolux.foods.hr_service.infra.user_account.adapter.persistence;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountPersistenceException;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistence;
import com.cloudsolux.foods.hr_service.domain.user_account.model.persistence.UserAccountPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;
import com.cloudsolux.foods.hr_service.infra.user_account.entity.UserAccountEntity;
import com.cloudsolux.foods.hr_service.infra.user_account.repo.UserAccountRepo;
import com.cloudsolux.foods.hr_service.infra.user_account.util.UserAccountMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class UserAccountPersistenceAdapter implements UserAccountPersistence {

  private final UserAccountMapper mapper;
  private final UserAccountRepo repo;

  @Override
  public UserAccountPersistenceKey getKey() {
    return UserAccountPersistenceKey.USER_ACCOUNT_PERSISTENCE;
  }

  @Override
  public void save(UserAccount domain) {
    UserAccountValidationAux.validateDependency(mapper, "UserAccountMapper");
    UserAccountValidationAux.validateDependency(repo, "UserAccountRepo");

    UserAccountEntity entity = mapper.toEntity(domain);
    UserAccountValidationAux.validateDependency(entity, "UserAccountMapper");

    try {
      repo.save(entity);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("UserAccount")+" {}",
        e.getMessage(),
        e
      );
      throw new UserAccountPersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("UserAccount"));
    }
  }
}