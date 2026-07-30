package com.cloudsolux.foods.inventory_service.domain.product.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidDependencyException;

public final class ProductValidationAux {
  
  private ProductValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName)),
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Product", argumentName))
    );
  }

  public static void validatePositiveBigDecimal(BigDecimal value, String argumentName) {
    ValidationAux.validatePositiveBigDecimal(
      value, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName)), 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Product", argumentName, value)));
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName)), 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Product", argumentName, value)));
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateDependency(
      dependency, 
      () -> new ProductInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Product", dependencyType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateDependencyMap(
      dependency, 
      () -> new ProductInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Product", dependencyType)), 
      () -> new ProductInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Product", dependencyType)));
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateRegistryCreation(
      implementations, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", implementationsType)), 
      () -> new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("Product", implementationsType)));
  }
}
