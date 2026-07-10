package com.cloudsolux.foods.inventory_service.infra.product.adapter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.model.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationPort;

@Component
public class ProductAdaptersGetterAdapter implements ProductAdaptersGetter {

  private Map<ProductCreationKey, ProductCreationPort> productCreators;

  @Override
  public ProductCreationPort getCreator(ProductCreationKey key) {
    return productCreators.get(key);
  }
}