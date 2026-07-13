package com.cloudsolux.foods.inventory_service.domain.product.exception;

public class ProductConcurrentException extends RuntimeException {
 
  public ProductConcurrentException(String msg) {
    super(msg);
  }
}