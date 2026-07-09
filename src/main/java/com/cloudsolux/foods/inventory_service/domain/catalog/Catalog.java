package com.cloudsolux.foods.inventory_service.domain.catalog;

public abstract class Catalog {

  private Long id;

  protected Catalog(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}