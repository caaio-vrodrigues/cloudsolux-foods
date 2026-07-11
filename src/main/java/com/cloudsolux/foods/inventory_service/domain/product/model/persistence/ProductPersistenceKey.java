package com.cloudsolux.foods.inventory_service.domain.product.model.persistence;

public enum ProductPersistenceKey {
  
  PRODUCT_PERSISTENCE("PRODUCT_PERSISTENCE");

  public final String key;

  private ProductPersistenceKey(String key) {
    this.key = key;
  }
}