package com.cloudsolux.foods.inventory_service.domain.product.exception;

public class ProductDataAccessException extends RuntimeException {
  
  public ProductDataAccessException(String msg) {
    super(msg);
  }
}