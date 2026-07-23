package com.cloudsolux.foods.inventory_service.infra.product.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductAdaptersGetter {

  private final Map<ProductFactoryKey, ProductFactoryPort> productFactories;
  private final Map<ProductValidationKey, ProductValidationPort> productValidators;
  private final Map<ProductPersistenceKey, ProductPersistencePort> productPersistences;

  public ProductFactoryPort getProductFactory(ProductFactoryKey key) {
    ProductValidationAux.validateArgument(key, "ProductFactoryKey");

    ProductValidationAux.validateDependencyMap(
      productFactories, "ProductFactoryPort");

    return productFactories.get(key);
  }

  public ProductValidationPort getValidator(ProductValidationKey key) {
    ProductValidationAux.validateArgument(key, "ProductValidationKey");

    ProductValidationAux.validateDependencyMap(
      productValidators, "ProductValidationPort");

    return productValidators.get(key);
  }

  public ProductPersistencePort getPersistence(ProductPersistenceKey key) {
    ProductValidationAux.validateArgument(key, "ProductPersistenceKey");

    ProductValidationAux.validateDependencyMap(
      productPersistences, "ProductPersistencePort");

    return productPersistences.get(key);
  }
}