package com.cloudsolux.foods.inventory_service.domain.inventory.exception;

public class InventoryInvalidArgumentException extends RuntimeException {
 
  public InventoryInvalidArgumentException(String msg) {
    super(msg);
  }
}