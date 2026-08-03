package com.cloudsolux.foods.hr_service.infra.user_account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsolux.foods.hr_service.infra.user_account.entity.UserAccountEntity;

public interface UserAccountRepo extends JpaRepository<UserAccountEntity, Long> {
  
  boolean existsByEmail(String email);
}