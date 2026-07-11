package com.cloudsolux.foods.inventory_service.infra.product.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;

@Component
public class ProductFactoryAdapter implements ProductFactory {

  @Override
  public ProductFactoryKey getKey() {
    return ProductFactoryKey.PRODUCT_CREATION;
  }

  @Override
  public Product create(ProductCreationCommand command) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}