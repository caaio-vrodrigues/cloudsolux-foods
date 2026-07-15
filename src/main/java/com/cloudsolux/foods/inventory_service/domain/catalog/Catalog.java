package com.cloudsolux.foods.inventory_service.domain.catalog;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.catalog.exception.CatalogInvalidArgumentException;

public abstract class Catalog {

  private final Long id;

  protected Catalog(Long id) {
    if(id == null) {
      throw new CatalogInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Catalog", "Long"));
    }
    if(id < 1) {
      throw new CatalogInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Catalog", "id", BigDecimal.valueOf(id)));
    }
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Catalog ['id="+id+"']";
  }
}