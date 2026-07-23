package com.cloudsolux.foods.inventory_service.domain.product.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidDependencyException;

public final class ProductValidationAux {
  
  private ProductValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    if(argument == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentType));
  }

  public static void validateString(String value, String argumentName) {
    if(value == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName));
		if(value.isBlank())
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Product", argumentName));
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    if(value == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName));
    if(value < 1)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Product", argumentName, BigDecimal.valueOf(value)));
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    if(dependency == null)
      throw new ProductInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    if(dependency == null)
      throw new ProductInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
    if(dependency.isEmpty())
      throw new ProductInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList(dependencyType));
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    if(implementations == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", implementationsType));
    if(implementations.isEmpty())
      throw new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList(implementationsType));
  }
}
