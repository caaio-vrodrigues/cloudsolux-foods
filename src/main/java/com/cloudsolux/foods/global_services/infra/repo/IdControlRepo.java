package com.cloudsolux.foods.global_services.infra.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.entity.IdControlEntity;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;

public interface IdControlRepo extends JpaRepository<IdControlEntity, IdControlKey> {
  
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @QueryHints(@QueryHint(name="jakarta.persistence.lock.timeout", value="5000"))
	Optional<IdControlEntity> findByKey(IdControlKey key);
}