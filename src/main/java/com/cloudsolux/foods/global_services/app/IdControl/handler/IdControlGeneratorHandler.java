package com.cloudsolux.foods.global_services.app.IdControl.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlNotFoundException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFinder;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlMapper;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlPersistence;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlUpdater;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdControlGeneratorHandler {

  private final IdControlFinder finder;
  private final IdControlMapper mapper;
  private final IdControlUpdater updater;
  private final IdControlPersistence persistence;
  
  @Transactional
  public Long generateId(IdControlKey key) {
    IdControlValidationAux.validateArgument(key, "IdControlKey");

    IdControlEntity entity = finder.findByKey(key)
      .orElseThrow(() -> new IdControlNotFoundException(IdControlMsgCreator.notFoundMsg(key)));

    IdControl domain = mapper.toDomain(entity);
    IdControlValidationAux.validateDependencyResult(domain, "IdControlMapper", "IdControl");

    Long id = domain.getNextValue();
    IdControl updatedDomain = domain.increment();

    IdControlEntity updatedEntity = updater.update(entity, updatedDomain);
    persistence.save(updatedEntity);

    return id;
  }
}