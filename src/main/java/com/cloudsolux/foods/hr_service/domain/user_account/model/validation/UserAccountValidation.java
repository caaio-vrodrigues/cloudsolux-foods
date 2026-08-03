package com.cloudsolux.foods.hr_service.domain.user_account.model.validation;

public interface UserAccountValidation extends UserAccountValidationPort {
 
  void validateUniqueness(String email);
}