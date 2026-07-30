package com.cloudsolux.foods.global_services.infra.id_control.util;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlAccessException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.repo.IdControlRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class IdControlFinder {

	private final IdControlRepo repo;

  public Optional<IdControlEntity> findByKey(IdControlKey key) {
		IdControlValidationAux.validateArgument(key, "IdControlKey");
		try{
			return repo.findByKey(key);
		}
		catch(DataAccessException e) {
			log.error(GlobalMsgCreator.dataAccessLogMsg("IdControlEntity")+". {}", 
				e.getMessage(), e
			);
			throw new IdControlAccessException(GlobalMsgCreator
				.dataAccessFailureMsg("IdControlEntity"));
		}
  }
}