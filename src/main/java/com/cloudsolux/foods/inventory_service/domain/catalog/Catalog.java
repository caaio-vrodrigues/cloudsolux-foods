package com.cloudsolux.foods.inventory_service.domain.catalog;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.catalog.exception.CatalogInvalidArgumentException;

public abstract class Catalog {

  private final Long id;

  protected Catalog(Long id) {
    validatePositiveLong(id, "id");
    this.id = id;
  }

  private void validatePositiveLong(Long value, String fieldName) {
    if(value == null)
      throw new CatalogInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Department", fieldName));
    if(value < 1)
      throw new CatalogInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Department", fieldName, BigDecimal.valueOf(value)));
  }

  public Long getId() {
    return id;
  }

  public String toString() {
    return "Catalog ['id="+id+"']";
  }
}