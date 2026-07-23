package com.cloudsolux.foods.inventory_service.domain.inventory.exception;

public final class InventoryInvalidDependencyException extends RuntimeException {
  
  public InventoryInvalidDependencyException(String msg) {
    super(msg);
  }
}