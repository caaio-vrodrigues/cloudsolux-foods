package com.cloudsolux.foods.inventory_service.domain.product.exception;

public class ProductInvalidArgumentException extends RuntimeException {
 
  public ProductInvalidArgumentException(String msg) {
    super(msg);
  }
}