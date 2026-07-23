package com.cloudsolux.foods.inventory_service.domain.product.exception;

public final class ProductInvalidDependencyException extends RuntimeException {
 
  public ProductInvalidDependencyException(String msg) {
    super(msg);
  }
}