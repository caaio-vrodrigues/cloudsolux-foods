package com.cloudsolux.foods.inventory_service.infra.inventory.adapter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryAdaptersGetterAdapter implements InventoryAdaptersGetter {

  private Map<InventoryFactoryKey, InventoryFactoryPort> inventoryFactories;
  private Map<InventoryPersistenceKey, InventoryPersistencePort> inventoryPersistences;

  @Override
  public InventoryFactoryPort getFactory(InventoryFactoryKey key) {
    return inventoryFactories.get(key);
  }

  @Override
  public InventoryPersistencePort getPersistence(InventoryPersistenceKey key) {
    return inventoryPersistences.get(key);
  }
}