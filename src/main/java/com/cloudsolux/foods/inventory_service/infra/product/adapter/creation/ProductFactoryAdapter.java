package com.cloudsolux.foods.inventory_service.infra.product.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactoryKey;

@Component
public class ProductFactoryAdapter implements ProductFactory {

  @Override
  public ProductFactoryKey getKey() {
    return ProductFactoryKey.PRODUCT_CREATION;
  }

  @Override
  public Product create(ProductCreationCommand command, Long id) {
    if(command == null) {
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ProductEntity", "ProductCreationCommand"));
    }
    return Product.builder()
      .id(id)
      .name(command.getName())
      .model(command.getModel())
      .brand(command.getBrand())
      .build();
  }
}