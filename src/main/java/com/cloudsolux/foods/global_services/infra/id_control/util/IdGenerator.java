package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.id_control.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.id_control.repo.IdControlRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IdGenerator {

  private final IdControlRepo repo;

  public Long getId(IdControlKey key) {
		if(key == null) {
			throw new IdControlInvalidArgumentException(GlobalMsgCreator
				.nullArgumentMsg("IdControl", "IdControlKey"));
		}
    IdControlEntity idControl = repo.findByKey(key)
			.orElseGet(() -> {
				IdControlEntity firstId = IdControlEntity.builder()
					.key(key)
					.nextValue(1L)
					.build();
				return repo.save(firstId);
			});
		Long currentAvailableId = idControl.getNextValue();
		idControl.increment();
		repo.save(idControl);
		return currentAvailableId;
  }
}