package com.cloudsolux.foods.inventory_service.infra.product.adapter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.model.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

@Component
public class ProductAdaptersGetterAdapter implements ProductAdaptersGetter {

  private Map<ProductCreationKey, ProductCreationPort> productFactories;
  private Map<ProductValidationKey, ProductValidationPort> productValidators;
  private Map<ProductSavingKey, ProductSavingPort> productSavers;
  private Map<ProductDTOFactoryKey, ProductDTOFactoryPort> productDTOFactories;

  @Override
  public ProductCreationPort getProductFactory(ProductCreationKey key) {
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
  public ProductSavingPort getSavers(ProductSavingKey key) {
    return productSavers.get(key);
  }
}