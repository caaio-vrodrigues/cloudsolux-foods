package com.cloudsolux.foods.inventory_service.domain.inventory.exception;

public class InventoryInjectionFailureException extends RuntimeException {
  
  public InventoryInjectionFailureException(String msg) {
    super(msg);
  }
}