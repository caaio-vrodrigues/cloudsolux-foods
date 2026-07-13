package com.cloudsolux.foods.inventory_service.infra.product.adapter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.model.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.dto.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.dto.ProductDTOFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

@Component
public class ProductAdaptersGetterAdapter implements ProductAdaptersGetter {

  private Map<ProductFactoryKey, ProductFactoryPort> productFactories;
  private Map<ProductValidationKey, ProductValidationPort> productValidators;
  private Map<ProductPersistenceKey, ProductPersistencePort> productPersistences;
  private Map<ProductDTOFactoryKey, ProductDTOFactoryPort> productDTOFactories;

  @Override
  public ProductFactoryPort getProductFactory(ProductFactoryKey key) {
    return productFactories.get(key);
  }

  @Override
  public ProductDTOFactoryPort getProductDTOFactory(ProductDTOFactoryKey key) {
    return productDTOFactories.get(key);
  }

  @Override
  public ProductValidationPort getValidator(ProductValidationKey key) {
    return productValidators.get(key);
  }

  @Override
  public ProductPersistencePort getPersistence(ProductPersistenceKey key) {
    return productPersistences.get(key);
  }
}