package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlPersistenceException;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.repo.IdControlRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class IdControlPersistence {
  
  private final IdControlRepo repo;

  public void save(IdControlEntity entity) {
    if(entity == null) {
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControlEntity", "IdControlEntity"));
    }
    try{
      repo.save(entity);
    }
    catch(DataIntegrityViolationException | OptimisticLockingFailureException e) {
      log.error(GlobalMsgCreator.persistenceFailLogMsg("IdControlEntity")+" {}", 
        e.getMessage(), e
      );
      throw new IdControlPersistenceException(GlobalMsgCreator
        .persistenceFailLogMsg("IdControlEntity"));
    }
  }

  public void save(IdControlEntity entity, IdControl domain) {
    if(entity == null)
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControlEntity", "IdControlEntity"));
    if(domain == null) {
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControlEntity", "IdControl"));
    }
    IdControlEntity updated = entity.toBuilder()
      .nextValue(domain.getNextValue())
      .build();
    this.save(updated);
  }
}