package com.cloudsolux.foods.inventory_service.domain.inventory.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidDependencyException;

public final class InventoryValidationAux {
  
  private InventoryValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName)), 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Inventory", argumentName))
    );
  }

  public static void validatePositiveBigDecimal(BigDecimal value, String argumentName) {
    ValidationAux.validatePositiveBigDecimal(
      value, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName)), 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Inventory", argumentName, value))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName)), 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Inventory", argumentName, value))
    );
  }

  public static void validateDependency(Object dependency, String dependencyType) {
    ValidationAux.validateDependency(
      dependency, 
      () -> new InventoryInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Inventory", dependencyType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateDependencyMap(
      dependency, 
      () -> new InventoryInvalidDependencyException(GlobalMsgCreator
        .nullDependencyMsg("Inventory", dependencyType)), 
      () -> new InventoryInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Inventory", dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateRegistryCreation(
      implementations, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", implementationsType)), 
      () -> new InventoryInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("Inventory", implementationsType))
    );
  }
}