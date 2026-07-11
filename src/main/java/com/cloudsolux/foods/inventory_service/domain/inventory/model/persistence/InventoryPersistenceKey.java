package com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence;

public enum InventoryPersistenceKey {
  
  INVENTORY_PERSISTENCE("INVENTORY_PERSISTENCE");

  public final String key;

  private InventoryPersistenceKey(String key) {
    this.key = key;
  }
}
