package com.cloudsolux.foods.inventory_service.domain.product.model.saving;

public enum ProductSavingKey {
  
  SAVE_PRODUCT("SAVE_PRODUCT");

  public final String key;

  private ProductSavingKey(String key) {
    this.key = key;
  }
}