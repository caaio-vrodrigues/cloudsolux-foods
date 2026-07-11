package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.validation;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryAdaptersGetterAdapter implements InventoryAdaptersGetter {

  private Map<InventoryValidationKey, InventoryValidationPort> getInventoryValidators;
  private Map<InventoryFactoryKey, InventoryFactoryPort> getInventoryFactories;
  private Map<InventoryPersistenceKey, InventoryPersistencePort> getInventoryPersistences;

  @Override
  public InventoryValidationPort getValidator(InventoryValidationKey key) {
    return getInventoryValidators.get(key);
  }

  @Override
  public InventoryFactoryPort getFactory(InventoryFactoryKey key) {
    return getInventoryFactories.get(key);
  }

  @Override
  public InventoryPersistencePort getPersistence(InventoryPersistenceKey key) {
    return getInventoryPersistences.get(key);
  }
}