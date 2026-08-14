package com.cloudsolux.foods.inventory_service.domain.product.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductAlreadyExistsException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidDependencyException;

public final class ProductValidationAux {
  
  private ProductValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
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

  public static void validatePositive(BigDecimal value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName)), 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Product", argumentName, value)));
  }

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", argumentName)), 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Product", argumentName, value)));
  }

  public static void validateDependencyResult(
    Object dependency, String dependencyType, String resultType
  ) {
    ValidationAux.validateNull(
      dependency, 
      () -> new ProductInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("Product", dependencyType, resultType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new ProductInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg("Product", dependencyType)), 
      () -> new ProductInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Product", dependencyType)));
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", implementationsType)), 
        () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullListElementMsg("Product", implementationsType)),
      () -> new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("Product", implementationsType)));
  }

  public static void validateUniqueness(
    Boolean existsByConstraint, String name, String model, String brand
  ) {
    if(existsByConstraint == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", "existsByConstraint"));

    if(name == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", "name"));
    
    if(model == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", "model"));
      
    if(brand == null)
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", "brand"));

    if(existsByConstraint) 
      throw new ProductAlreadyExistsException(
        ProductMsgCreator.uniquenessViolationMsg(name, model, brand));
  }

  public static void validateIdCorrelation(Long productId, Long inventoryId) {
    ValidationAux.validateSameLong(
      productId, 
      inventoryId, 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", "product.id")), 
      () -> new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Product", "inventory.catalogId")), 
      () -> new ProductInvalidArgumentException(ProductMsgCreator
        .unrelatedIdMsg(productId, inventoryId)));
  }
}