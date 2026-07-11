package com.cloudsolux.foods.inventory_service.domain.inventory.model.validation;

import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;

public interface InventoryCreationCommandValidation extends InventoryValidationPort {
  
  void validateCreationCommand(InventoryCreationCommand command);
}