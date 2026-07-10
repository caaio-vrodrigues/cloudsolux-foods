package com.cloudsolux.foods.inventory_service.app.inventory.handler;

import org.springframework.stereotype.Service;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.dto.InventoryCreationCommand;

@Service
public class InventoryCreationHandler {

  public Inventory create(InventoryCreationCommand inventoryCreationCommand) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}