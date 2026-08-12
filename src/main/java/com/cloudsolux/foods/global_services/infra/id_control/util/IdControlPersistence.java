package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlPersistenceException;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.repo.IdControlRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class IdControlPersistence {
  
  private final IdControlRepo repo;
  private final IdControlMapper mapper;

  public IdControlEntity save(IdControl domain) {
    IdControlEntity entity = mapper.toEntity(domain);

    IdControlValidationAux.validateDependencyResult(
      entity, "IdControlMapper", "IdControlEntity");

    try{
      return repo.save(entity);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("IdControl")+" {}", 
        e.getMessage(), 
        e
      );
      throw new IdControlPersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("IdControl"));
    }
  }

  public void save(IdControlEntity entity) {
    IdControlValidationAux.validateArgument(entity, "IdControlEntity");
    
    try{
      repo.save(entity);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("IdControl")+" {}", 
        e.getMessage(), 
        e
      );
      throw new IdControlPersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("IdControl"));
    }
  }
}