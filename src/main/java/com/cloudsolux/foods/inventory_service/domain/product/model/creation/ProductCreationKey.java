package com.cloudsolux.foods.inventory_service.domain.product.model.creation;

public enum ProductCreationKey {

  CREATE("CREATE");

  public final String key;

  private ProductCreationKey(String key) {
    this.key = key;
  }
}