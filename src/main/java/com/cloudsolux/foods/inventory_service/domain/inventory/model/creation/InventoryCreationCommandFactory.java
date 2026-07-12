package com.cloudsolux.foods.inventory_service.domain.inventory.model.creation;

import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;

public interface InventoryCreationCommandFactory extends InventoryCommandFactoryPort {
  
  InventoryCreationCommand create(ProductCreationCommand productCommand, Long id);
}