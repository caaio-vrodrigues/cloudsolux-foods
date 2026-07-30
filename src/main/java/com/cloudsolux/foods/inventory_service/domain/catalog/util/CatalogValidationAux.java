package com.cloudsolux.foods.inventory_service.domain.catalog.util;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.inventory_service.domain.catalog.exception.CatalogInvalidArgumentException;

public class CatalogValidationAux {
  
  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new CatalogInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Catalog", argumentName)), 
      () -> new CatalogInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Catalog", argumentName, value))
    );
  }
}