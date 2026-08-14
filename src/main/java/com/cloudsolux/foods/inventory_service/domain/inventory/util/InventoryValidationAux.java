package com.cloudsolux.foods.inventory_service.domain.inventory.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidDependencyException;

public final class InventoryValidationAux {
  
  private InventoryValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
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

  public static void validatePositive(BigDecimal value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName)), 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Inventory", argumentName, value))
    );
  }

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName)), 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Inventory", argumentName, value))
    );
  }

  public static void validateDependencyResult(
    Object dependency, String dependencyType, String resultType
  ) {
    ValidationAux.validateNull(
      dependency, 
      () -> new InventoryInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("Inventory", dependencyType, resultType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new InventoryInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", dependencyType)), 
      () -> new InventoryInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Inventory", dependencyType))
    );
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", implementationsType)),
      () -> new InventoryInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("Inventory", implementationsType))
    );
  }

  public static void validatePositiveOrZero(BigDecimal amount, String argumentName) {
    ValidationAux.validatePositiveOrZero(
      amount, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", argumentName)), 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .positiveOrZeroMsg("Inventory", argumentName, amount))
    );
  }

  public static void validateSameUnitOfMeasure(
    UnitOfMeasure current, 
    UnitOfMeasure received, 
    String currentArgumentName, 
    String receivedArgumentName
  ) {
    ValidationAux.validateSameUnitOfMeasure(
      current, 
      received, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", currentArgumentName)),
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", receivedArgumentName)),
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .invalidUnitOfMeasureMsg("Inventory", received, current)));
  }

  public static void validateUnderZeroResult(
    BigDecimal current, 
    BigDecimal received, 
    String currentArgumentName, 
    String receivedArgumentName
  ) {
    ValidationAux.validateUnderZeroResult(
      current, 
      received, 
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", currentArgumentName)),
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", receivedArgumentName)),
      () -> new InventoryInvalidArgumentException(GlobalMsgCreator
        .underZeroResult("Inventory", currentArgumentName, received, current)));
  }
}