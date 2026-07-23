package com.cloudsolux.foods.inventory_service.infra.product.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;

@Component
public final class ProductFactoryAdapter implements ProductFactory {

  @Override
  public ProductFactoryKey getKey() {
    return ProductFactoryKey.PRODUCT_CREATION;
  }

  @Override
  public Product create(ProductCreationCommand command, Long id) {
    ProductValidationAux.validateArgument(command, "ProductCreationCommand");
    ProductValidationAux.validatePositiveLong(id, "id");

    return Product.builder()
      .id(id)
      .name(command.getName())
      .model(command.getModel())
      .brand(command.getBrand())
      .build();
  }
}