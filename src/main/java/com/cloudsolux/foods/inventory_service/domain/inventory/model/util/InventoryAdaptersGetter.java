package com.cloudsolux.foods.inventory_service.domain.inventory.model.util;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryCommandFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;

public interface InventoryAdaptersGetter {
  
  InventoryFactoryPort getFactory(InventoryFactoryKey key);
  InventoryPersistencePort getPersistence(InventoryPersistenceKey key);
  InventoryMapperPort getMapper(InventoryMapperKey key);
  InventoryCommandFactoryPort getCreationCommandFactory(InventoryFactoryKey key);
}