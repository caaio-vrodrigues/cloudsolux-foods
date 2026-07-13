package com.cloudsolux.foods.inventory_service.domain.product.model.creation.dto;

public enum ProductDTOFactoryKey {
  
  CREATE_RESPONSE("CREATE_RESPONSE");

  public final String key;

  private ProductDTOFactoryKey(String key) {
    this.key = key;
  }
}