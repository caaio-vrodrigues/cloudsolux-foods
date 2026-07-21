package com.cloudsolux.foods.inventory_service.domain.product.exception;

public class ProductInvalidDependencyException extends RuntimeException {
 
  public ProductInvalidDependencyException(String msg) {
    super(msg);
  }
}