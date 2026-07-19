package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInjectionFailureException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryCommandFactoryPort;
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
  private final Map<InventoryFactoryKey, InventoryCommandFactoryPort> inventoryCreationCommandFactories;

  private void validateImplementations(
    Map<?, ?> bean, String beanName, String portName, Object key
  ) {
    if(bean == null)
      throw new InventoryInjectionFailureException(
        GlobalMsgCreator.nullIngectionFailureMsg(portName, beanName));
    if(bean.isEmpty())
      throw new InventoryInjectionFailureException(
        GlobalMsgCreator.emptyInjectionList(portName, beanName));
    if(key == null)
      throw new InventoryInvalidArgumentException(
        GlobalMsgCreator.nullArgumentMsg(portName, "key"));
  }

  public InventoryFactoryPort getFactory(InventoryFactoryKey key) {
    validateImplementations(
      inventoryFactories, "inventoryFactories", 
      "InventoryFactoryPort", key
    );
    return inventoryFactories.get(key);
  }

  public InventoryPersistencePort getPersistence(InventoryPersistenceKey key) {
    validateImplementations(
      inventoryPersistences, "inventoryPersistences", 
      "InventoryPersistencePort", key
    );
    return inventoryPersistences.get(key);
  }

  public InventoryCommandFactoryPort getCreationCommandFactory(InventoryFactoryKey key) {
    validateImplementations(
      inventoryCreationCommandFactories, "inventoryCreationCommandFactories", 
      "InventoryCommandFactoryPort",  key
    );
    return inventoryCreationCommandFactories.get(key);
  }
}