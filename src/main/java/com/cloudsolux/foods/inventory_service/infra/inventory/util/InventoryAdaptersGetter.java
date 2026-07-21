package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidDependencyException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryAdaptersGetter {

  private final Map<InventoryFactoryKey, InventoryFactoryPort> inventoryFactories;
  private final Map<InventoryPersistenceKey, InventoryPersistencePort> inventoryPersistences;

  private void validateDependency(
    Map<?, ?> bean, String beanName, String portName
  ) {
    if(bean == null)
      throw new InventoryInvalidDependencyException(
        GlobalMsgCreator.nullDependencyMsg(portName, beanName));
    if(bean.isEmpty())
      throw new InventoryInvalidDependencyException(
        GlobalMsgCreator.emptyDependencyList(portName, beanName));
  }

  public InventoryFactoryPort getFactory(InventoryFactoryKey key) {
    if(key == null) {
      throw new InventoryInvalidArgumentException(
        GlobalMsgCreator.nullArgumentMsg(
          "InventoryFactoryPort", 
          "InventoryFactoryKey"));
    }
    validateDependency(
      inventoryFactories, 
      "inventoryFactories", 
      "InventoryFactoryPort"
    );
    return inventoryFactories.get(key);
  }

  public InventoryPersistencePort getPersistence(InventoryPersistenceKey key) {
    if(key == null) {
      throw new InventoryInvalidArgumentException(
        GlobalMsgCreator.nullArgumentMsg(
          "InventoryPersistencePort", 
          "InventoryPersistenceKey"));
    }
    validateDependency(
      inventoryPersistences,
       "inventoryPersistences", 
      "InventoryPersistencePort"
    );
    return inventoryPersistences.get(key);
  }
}