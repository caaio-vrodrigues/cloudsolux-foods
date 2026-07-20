package com.cloudsolux.foods.global_services.app.IdControl.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFactory;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFinder;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlMapper;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlPersistence;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdControlGeneratorHandler {

  private final IdControlFinder finder;
  private final IdControlFactory factory;
  private final IdControlPersistence persistence;
  private final IdControlMapper mapper;
  
  @Transactional
  public Long generateId(IdControlKey key) {
    if(key == null) {
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", "IdControlKey"));
    }
    IdControlEntity entity = finder.findByKey(key).orElseGet(
      () -> factory.create(key)
    );
    IdControl domain = mapper.toDomain(entity);
    Long id = domain.getNextValue();
    domain.increment();
    persistence.save(entity, domain);
    return id;
  }
}