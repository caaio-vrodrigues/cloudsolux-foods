package com.cloudsolux.foods.inventory_service.app.inventory.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.dto.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryCreationCommandValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryCreationHandler {

  private InventoryAdaptersGetter adapters;

  @Transactional
  public Inventory create(InventoryCreationCommand inventoryCreationCommand) {
    InventoryCreationCommandValidation validator = (InventoryCreationCommandValidation) adapters
      .getValidator(inventoryCreationCommand.getValidationKey());
    validator.validateCreationCommand(inventoryCreationCommand);
    
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}