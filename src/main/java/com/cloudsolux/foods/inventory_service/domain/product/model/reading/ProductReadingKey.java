package com.cloudsolux.foods.inventory_service.domain.product.model.reading;

public enum ProductReadingKey {
  
  FIND_ALL("FIND_ALL");

  public final String key;

  private ProductReadingKey(String key) {
    this.key = key;
  }
}