package com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain;

public enum ProductFactoryKey {

  PRODUCT_CREATION("PRODUCT_CREATION");

  public final String key;

  private ProductFactoryKey(String key) {
    this.key = key;
  }
}