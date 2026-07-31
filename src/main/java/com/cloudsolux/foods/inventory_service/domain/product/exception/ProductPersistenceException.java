package com.cloudsolux.foods.inventory_service.domain.product.exception;

public final class ProductPersistenceException extends RuntimeException {
 
  public ProductPersistenceException(String msg) {
    super(msg);
  }
}