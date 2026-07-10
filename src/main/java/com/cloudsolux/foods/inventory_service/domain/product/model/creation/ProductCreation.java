package com.cloudsolux.foods.inventory_service.domain.product.model.creation;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreateCommand;

public interface ProductCreation extends ProductCreationPort {
  
  Product create(ProductCreateCommand command);
}