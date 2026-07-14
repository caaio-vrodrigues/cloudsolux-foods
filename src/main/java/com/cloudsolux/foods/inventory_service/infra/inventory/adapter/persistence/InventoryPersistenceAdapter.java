package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.persistence;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryConcurrentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistence;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.infra.inventory.adapter.util.InventoryMapperAdapter;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.InventoryEntity;
import com.cloudsolux.foods.inventory_service.infra.inventory.repo.InventoryRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryPersistenceAdapter implements InventoryPersistence {

  private final InventoryMapperAdapter mapper;
  private final InventoryRepo repo;

  @Override
  public InventoryPersistenceKey getKey() {
    return InventoryPersistenceKey.INVENTORY_PERSISTENCE;
  }

  @Override
  public void save(Inventory inventory) {
    if(inventory == null) {
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("InventoryEntity", "Inventory"));
    }
    InventoryEntity entity = mapper.toEntity(inventory);
    try {
      repo.save(entity);
    }
    catch(DataIntegrityViolationException | OptimisticLockingFailureException e) {
      log.error(GlobalMsgCreator.persistenceFailLogMsg("null")+". {}", 
        e.getMessage(), e);
      throw new InventoryConcurrentException(GlobalMsgCreator
        .concurrentPersistenceMsg("InventoryEntity"));
    }
  }
}