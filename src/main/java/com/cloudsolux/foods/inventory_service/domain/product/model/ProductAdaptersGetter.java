package com.cloudsolux.foods.inventory_service.domain.product.model;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationPort;

public interface ProductAdaptersGetter {
  
  ProductCreationPort getCreator(ProductCreationKey key);
}