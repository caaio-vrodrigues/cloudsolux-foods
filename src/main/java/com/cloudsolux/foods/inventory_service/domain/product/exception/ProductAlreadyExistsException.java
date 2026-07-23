package com.cloudsolux.foods.inventory_service.domain.product.exception;

public final class ProductAlreadyExistsException extends RuntimeException {
 
  public ProductAlreadyExistsException(String msg) {
    super(msg);
  }
}