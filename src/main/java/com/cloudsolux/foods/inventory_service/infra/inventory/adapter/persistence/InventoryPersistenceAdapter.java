package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.persistence;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistence;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;

@Component
public class InventoryPersistenceAdapter implements InventoryPersistence {

  @Override
  public InventoryPersistenceKey getKey() {
    return InventoryPersistenceKey.INVENTORY_PERSISTENCE;
  }

  @Override
  public void save(Inventory inventory) {
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }
}