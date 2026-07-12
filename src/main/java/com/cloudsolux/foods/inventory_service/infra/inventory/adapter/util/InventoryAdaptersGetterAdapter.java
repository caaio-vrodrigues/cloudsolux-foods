package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryCommandFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.util.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.util.InventoryMapperKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.util.InventoryMapperPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryAdaptersGetterAdapter implements InventoryAdaptersGetter {

  private Map<InventoryFactoryKey, InventoryFactoryPort> inventoryFactories;
  private Map<InventoryPersistenceKey, InventoryPersistencePort> inventoryPersistences;
  private Map<InventoryMapperKey, InventoryMapperPort> inventoryMappers;
  private Map<InventoryFactoryKey, InventoryCommandFactoryPort> inventoryCreationCommandFactories;

  @Override
  public InventoryFactoryPort getFactory(InventoryFactoryKey key) {
    return inventoryFactories.get(key);
  }

  @Override
  public InventoryPersistencePort getPersistence(InventoryPersistenceKey key) {
    return inventoryPersistences.get(key);
  }

  @Override
  public InventoryMapperPort getMapper(InventoryMapperKey key) {
    return inventoryMappers.get(key);
  }

  @Override
  public InventoryCommandFactoryPort getCreationCommandFactory(InventoryFactoryKey key) {
    return inventoryCreationCommandFactories.get(key);
  }
}