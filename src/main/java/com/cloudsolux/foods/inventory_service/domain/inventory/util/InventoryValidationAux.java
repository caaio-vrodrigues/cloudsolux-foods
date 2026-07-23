package com.cloudsolux.foods.inventory_service.domain.inventory.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidDependencyException;

public final class InventoryValidationAux {
  
  private InventoryValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    if(argument == null)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentType));
  }

  public static void validateString(String value, String argumentName) {
    if(value == null)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName));
		if(value.isBlank())
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Inventory", argumentName));
  }

  public static void validatePositiveBigDecimal(BigDecimal value, String argumentName) {
    if(value == null)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName));
    if(value.compareTo(BigDecimal.ZERO) < 1)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Inventory", argumentName, value));
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    if(value == null)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName));
    if(value < 1)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Inventory", argumentName, value));
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    if(dependency == null)
      throw new InventoryInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    if(dependency == null)
      throw new InventoryInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg(dependencyType));
    if(dependency.isEmpty())
      throw new InventoryInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList(dependencyType));
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    if(implementations == null)
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", implementationsType));
    if(implementations.isEmpty())
      throw new InventoryInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList(implementationsType));
  }
}