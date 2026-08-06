package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;

@Component
public final class IdControlUpdater {
  
  public IdControlEntity update(IdControlEntity entity, IdControl domain) {
    IdControlValidationAux.validateArgument(entity, "IdControlEntity");
    IdControlValidationAux.validateArgument(domain, "IdControl");
    IdControlValidationAux.validateIdControlKey(entity.getKey(), domain.getKey());

    return entity.toBuilder()
      .nextValue(domain.getNextValue())
      .build();
  }
}