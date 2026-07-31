package com.cloudsolux.foods.inventory_service.domain.inventory.exception;

public final class InventoryPersistenceException extends RuntimeException {
 
  public InventoryPersistenceException(String msg) {
    super(msg);
  }
}