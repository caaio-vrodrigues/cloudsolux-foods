package com.cloudsolux.foods.inventory_service.domain.inventory.model;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationPort;

public interface InventoryAdaptersGetter {
  
  InventoryValidationPort getValidator(InventoryValidationKey key);
}