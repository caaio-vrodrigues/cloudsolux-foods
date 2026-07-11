package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactory;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;

@Component
public class InventoryFactoryAdapter implements InventoryFactory {

  @Override
  public InventoryFactoryKey getKey() {
    return InventoryFactoryKey.INVENTORY_CREATION;
  }

  @Override
  public Inventory create(InventoryCreationCommand command) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}