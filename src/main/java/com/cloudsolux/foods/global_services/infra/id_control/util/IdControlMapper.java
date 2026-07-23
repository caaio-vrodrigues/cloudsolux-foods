package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;

@Component
public class IdControlMapper {
  
  public IdControl toDomain(IdControlEntity entity) {
    IdControlValidationAux.validateArgument(
      entity, "IdControlEntity");

    return IdControl.builder()
      .key(entity.getKey())
      .nextValue(entity.getNextValue())
      .build();
  }

  public IdControlEntity toEntity(IdControl domain) {
    IdControlValidationAux.validateArgument(
      domain, "IdControl");

    return IdControlEntity.builder()
      .key(domain.getKey())
      .nextValue(domain.getNextValue())
      .build();
  }
}