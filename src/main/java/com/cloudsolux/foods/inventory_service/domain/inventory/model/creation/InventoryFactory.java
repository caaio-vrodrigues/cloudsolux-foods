package com.cloudsolux.foods.inventory_service.domain.inventory.model.creation;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;

public interface InventoryFactory extends InventoryFactoryPort {
  
  Inventory create(InventoryCreationCommand command);
}