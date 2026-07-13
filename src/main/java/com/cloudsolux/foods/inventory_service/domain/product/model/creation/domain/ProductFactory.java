package com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;

public interface ProductFactory extends ProductFactoryPort {
  
  Product create(ProductCreationCommand command, Long id);
}