package com.cloudsolux.foods.inventory_service.domain.catalog;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.catalog.exception.CatalogInvalidArgumentException;

public abstract class Catalog {

  private final Long id;

  protected Catalog(Long id) {
    if(!(id instanceof Long)) {
      String receivedClassName = id != null ? 
        id.getClass().getSimpleName() : "null";
      throw new CatalogInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("Long", receivedClassName));
    }
    if(id < 1) {
      throw new CatalogInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Product", "id", BigDecimal.valueOf(id)));
    }
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String toString() {
    return "Catalog ['id="+id+"']";
  }
}