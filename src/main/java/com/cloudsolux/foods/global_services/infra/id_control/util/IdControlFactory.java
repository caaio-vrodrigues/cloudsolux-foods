package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;

@Component
public final class IdControlFactory {
  
  public IdControl create(IdControlKey key, Long nextValue) {
    IdControlValidationAux.validateArgument(key, "IdControlKey");
    IdControlValidationAux.validatePositive(nextValue, "nextValue");

    return IdControl.builder()
      .key(key)
      .nextValue(nextValue)
      .build();
  }
}