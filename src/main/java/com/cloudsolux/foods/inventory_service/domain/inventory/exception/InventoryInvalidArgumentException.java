package com.cloudsolux.foods.inventory_service.domain.inventory.exception;

public final class InventoryInvalidArgumentException extends RuntimeException {
 
  public InventoryInvalidArgumentException(String msg) {
    super(msg);
  }
}