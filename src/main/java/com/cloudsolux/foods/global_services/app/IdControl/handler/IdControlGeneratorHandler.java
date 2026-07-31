package com.cloudsolux.foods.global_services.app.IdControl.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFactory;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFinder;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlMapper;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlPersistence;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlUpdater;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdControlGeneratorHandler {

  private final IdControlFinder finder;
  private final IdControlFactory factory;
  private final IdControlMapper mapper;
  private final IdControlUpdater updater;
  private final IdControlPersistence persistence;
  
  @Transactional
  public Long generateId(IdControlKey key) {
    IdControlValidationAux.validateArgument(key, "IdControlKey");
    IdControlValidationAux.validateDependency(finder, "IdControlFinder");
    IdControlValidationAux.validateDependency(factory, "IdControlFactory");
    IdControlValidationAux.validateDependency(mapper, "IdControlMapper");
    IdControlValidationAux.validateDependency(persistence, "IdControlPersistence");

    IdControlEntity entity = finder.findByKey(key)
      .orElseGet(() -> null);
      
    IdControl domain;

    if(entity == null) {
      domain = factory.create(key);
      IdControlValidationAux.validateDependency(domain, "IdControlFactory");
    }
    else {
      domain = mapper.toDomain(entity);
      IdControlValidationAux.validateDependency(domain, "IdControlMapper");
    }

    Long id = domain.getNextValue();
    domain.increment();

    if(entity == null) {
      persistence.save(domain);
    }
    else {
      IdControlEntity updatedEntity = updater.update(entity, domain);
      persistence.save(updatedEntity);
    }
    
    return id;
  }
}