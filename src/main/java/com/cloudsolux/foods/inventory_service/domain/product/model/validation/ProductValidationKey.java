package com.cloudsolux.foods.inventory_service.domain.product.model.validation;

public enum ProductValidationKey {
  
  VALIDATE_CREATION_REQUEST("VALIDATE_CREATION_REQUEST");

  public final String key;

  private ProductValidationKey(String key) {
    this.key = key;
  }
}
