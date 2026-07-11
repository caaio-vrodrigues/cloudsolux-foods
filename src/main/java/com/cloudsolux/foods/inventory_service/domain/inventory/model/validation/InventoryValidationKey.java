package com.cloudsolux.foods.inventory_service.domain.inventory.model.validation;

public enum InventoryValidationKey {

  VALIDATE_CREATION_COMMAND("VALIDATE_CREATION_COMMAND");
  
  public final String key;

  private InventoryValidationKey(String key) {
    this.key = key;
  }
}
