package com.cloudsolux.foods.inventory_service.infra.product.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreateCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreation;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;

@Component
public class ProductCreationAdapter implements ProductCreation {

  @Override
  public ProductCreationKey getKey() {
    return ProductCreationKey.PRODUCT_CREATION;
  }

  @Override
  public Product create(ProductCreateCommand command) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}