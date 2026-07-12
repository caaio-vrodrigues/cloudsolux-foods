package com.cloudsolux.foods.inventory_service.app.inventory.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistence;
import com.cloudsolux.foods.inventory_service.infra.inventory.adapter.creation.InventoryFactoryAdapter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryCreationHandler {

  private InventoryAdaptersGetter adapters;

  @Transactional
  public Inventory create(InventoryCreationCommand command) {
    InventoryFactoryAdapter factory = (InventoryFactoryAdapter) adapters
      .getFactory(command.getFactoryKey());
    Inventory inventory = factory.create(command);

    InventoryPersistence persistence = (InventoryPersistence) adapters
      .getPersistence(command.getPersistenceKey());
    persistence.save(inventory);

    return inventory;
  }
}