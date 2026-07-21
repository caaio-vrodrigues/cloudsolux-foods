package com.cloudsolux.foods.inventory_service.infra.product.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidDependencyException;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductAdaptersGetter {

  private final Map<ProductFactoryKey, ProductFactoryPort> productFactories;
  private final Map<ProductValidationKey, ProductValidationPort> productValidators;
  private final Map<ProductPersistenceKey, ProductPersistencePort> productPersistences;

  private void validateDependency(
    Map<?, ?> bean, String beanName, String portName
  ) {
    if(bean == null)
      throw new ProductInvalidDependencyException(
        GlobalMsgCreator.nullDependencyMsg(portName, beanName));
    if(bean.isEmpty())
      throw new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyDependencyList(portName, beanName));
  }

  public ProductFactoryPort getProductFactory(ProductFactoryKey key) {
    if(key == null) {
      throw new ProductInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg(
          "ProductFactoryPort", 
          "ProductFactoryKey"));
    }
    validateDependency(
      productFactories, 
      "productFactories", 
      "ProductFactoryPort"
    );
    return productFactories.get(key);
  }

  public ProductValidationPort getValidator(ProductValidationKey key) {
    if(key == null) {
      throw new ProductInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg(
          "ProductValidationPort", 
          "ProductValidationKey"));
    }
    validateDependency(
      productValidators, 
      "productValidators", 
      "ProductValidationPort"
    );
    return productValidators.get(key);
  }

  public ProductPersistencePort getPersistence(ProductPersistenceKey key) {
    if(key == null) {
      throw new ProductInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg(
          "ProductPersistencePort", 
          "ProductPersistenceKey"));
    }
    validateDependency(
      productPersistences, 
      "productPersistences", 
      "ProductPersistencePort"
    );
    return productPersistences.get(key);
  }
}