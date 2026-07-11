package com.cloudsolux.foods.inventory_service.domain.inventory.model.validation;

import com.cloudsolux.foods.inventory_service.domain.inventory.dto.InventoryCreationCommand;

public interface InventoryCreationCommandValidation extends InventoryValidationPort {
  
  void validateCreationCommand(InventoryCreationCommand command);
}