package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;

@Component
public class IdControlMapper {
  
  public IdControl toDomain(IdControlEntity entity) {
    if(entity == null) {
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControlEntity", "IdControlEntity"));
    }
    return IdControl.builder()
      .key(entity.getKey())
      .nextValue(entity.getNextValue())
      .build();
  }

  public IdControlEntity toEntity(IdControl domain) {
    if(domain == null) {
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControlEntity", "IdControl"));
    }
    return IdControlEntity.builder()
      .key(domain.getKey())
      .nextValue(domain.getNextValue())
      .build();
  }
}