package com.cloudsolux.foods.inventory_service.domain.inventory.exception;

public final class InventoryConcurrentException extends RuntimeException {
 
  public InventoryConcurrentException(String msg) {
    super(msg);
  }
}