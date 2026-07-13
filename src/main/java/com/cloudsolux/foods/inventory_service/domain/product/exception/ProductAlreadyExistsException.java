package com.cloudsolux.foods.inventory_service.domain.product.exception;

public class ProductAlreadyExistsException extends RuntimeException {
 
  public ProductAlreadyExistsException(String msg) {
    super(msg);
  }
}