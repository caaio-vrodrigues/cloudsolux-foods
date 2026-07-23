package com.cloudsolux.foods.inventory_service.domain.catalog.exception;

public final class CatalogInvalidArgumentException extends RuntimeException {
  
  public CatalogInvalidArgumentException(String msg) {
    super(msg);
  }
}