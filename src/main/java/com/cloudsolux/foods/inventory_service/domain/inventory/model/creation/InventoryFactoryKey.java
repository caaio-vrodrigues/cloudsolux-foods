package com.cloudsolux.foods.inventory_service.domain.inventory.model.creation;

public enum InventoryFactoryKey {

  INVENTORY_CREATION("INVENTORY_CREATION");

  public final String key;
  
  private InventoryFactoryKey(String key) {
    this.key = key;
  }
}