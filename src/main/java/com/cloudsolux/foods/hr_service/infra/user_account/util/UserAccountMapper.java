package com.cloudsolux.foods.hr_service.infra.user_account.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;
import com.cloudsolux.foods.hr_service.domain.user_account.util.UserAccountValidationAux;
import com.cloudsolux.foods.hr_service.infra.user_account.entity.UserAccountEntity;

@Component
public final class UserAccountMapper {
 
  public UserAccountEntity toEntity(UserAccount domain) {
    UserAccountValidationAux.validateArgument(domain, "UserAccount");

    return UserAccountEntity.builder()
      .id(domain.getId())
      .firstName(domain.getFirstName())
      .lastName(domain.getLastName())
      .birthday(domain.getBirthday())
      .email(domain.getEmail())
      .password(domain.getPasswordHash())
      .role(domain.getRole())
      .active(domain.getActive())
      .build();
  }

  public UserAccount toDomain(UserAccountEntity entity) {
    UserAccountValidationAux.validateArgument(entity, "UserAccountEntity");

    return UserAccount.builder()
      .id(entity.getId())
      .firstName(entity.getFirstName())
      .lastName(entity.getLastName())
      .birthday(entity.getBirthday())
      .email(entity.getEmail())
      .password(entity.getPassword())
      .role(entity.getRole())
      .active(entity.isActive())
      .build();
  }
}