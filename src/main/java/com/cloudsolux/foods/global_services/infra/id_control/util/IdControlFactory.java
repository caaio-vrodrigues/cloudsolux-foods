package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;

@Component
public class IdControlFactory {
  
  public IdControlEntity create(IdControlKey key) {
    if(key == null) {
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", "IdControlKey"));
    }
    return IdControlEntity.builder()
      .key(key)
      .nextValue(1L)
      .build();
  }
}