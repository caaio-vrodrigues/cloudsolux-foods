package com.cloudsolux.foods.global_services.infra.adapter;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.infra.entity.IdControlEntity;
import com.cloudsolux.foods.global_services.infra.repo.IdControlRepo;
import com.cloudsolux.foods.global_services.model.id_control.IdControlKey;
import com.cloudsolux.foods.global_services.model.id_control.IdGenerator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IdGeneratorAdapter implements IdGenerator {

  private final IdControlRepo repo;

  @Override
  public Long getId(IdControlKey key) {
    IdControlEntity idControl = repo.findByKey(key)
			.orElseGet(() -> {
				IdControlEntity newIdControl = IdControlEntity.builder()
					.key(key)
					.nextValue(1L)
					.build();
				return repo.save(newIdControl);
			});
		Long currentAvailableId = idControl.getNextValue();
		idControl.increment();
		repo.save(idControl);
		return currentAvailableId;
  }
}