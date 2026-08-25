package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class InventoryAdaptersGetter {

  private final Map<InventoryFactoryKey, InventoryFactoryPort> inventoryFactories;
  private final Map<InventoryPersistenceKey, InventoryPersistencePort> inventoryPersistences;

  public InventoryFactoryPort getFactory(InventoryFactoryKey key) {
    InventoryValidationAux.validateArgument(key, "InventoryFactoryKey");

    InventoryValidationAux.validateDependencyMap(
      inventoryFactories, 
      "Map<InventoryFactoryKey, InventoryFactoryPort>");

    InventoryFactoryPort factory = inventoryFactories.get(key);

    InventoryValidationAux.validateDependencyResult(
      factory, 
      "inventoryFactories", 
      "InventoryFactoryPort");

    return factory;
  }

  public InventoryPersistencePort getPersistence(InventoryPersistenceKey key) {
    InventoryValidationAux.validateArgument(key, "InventoryPersistenceKey");
    
    InventoryValidationAux.validateDependencyMap(
      inventoryPersistences, 
      "Map<InventoryPersistenceKey, InventoryPersistencePort>");

    InventoryPersistencePort persistence = inventoryPersistences.get(key);

    InventoryValidationAux.validateDependencyResult(
      persistence,
      "inventoryPersistences", 
      "InventoryPersistencePort");

    return persistence;
  }
}