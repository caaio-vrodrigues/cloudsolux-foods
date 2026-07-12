package com.cloudsolux.foods.inventory_service.app.inventory.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryCreationCommandFactory;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistence;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.util.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.infra.inventory.adapter.creation.InventoryFactoryAdapter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryCreationHandler {

  private final InventoryAdaptersGetter adapters;

  @Transactional
  public Inventory create(ProductCreationCommand productCommand, Long id) {
    InventoryCreationCommandFactory commandFactory = (InventoryCreationCommandFactory) adapters
      .getCreationCommandFactory(InventoryFactoryKey.INVENTORY_CREATION_COMMAND_CREATION);
    InventoryCreationCommand command = commandFactory.create(productCommand, id);

    InventoryFactoryAdapter factory = (InventoryFactoryAdapter) adapters
      .getFactory(InventoryFactoryKey.INVENTORY_CREATION);
    Inventory inventory = factory.create(command);

    InventoryPersistence persistence = (InventoryPersistence) adapters
      .getPersistence(InventoryPersistenceKey.INVENTORY_PERSISTENCE);
    persistence.save(inventory);

    return inventory;
  }
}