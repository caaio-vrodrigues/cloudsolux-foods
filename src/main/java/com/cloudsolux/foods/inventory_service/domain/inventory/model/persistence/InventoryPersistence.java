package com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;

public interface InventoryPersistence extends InventoryPersistencePort {
 
  void save(Inventory inventory);
}