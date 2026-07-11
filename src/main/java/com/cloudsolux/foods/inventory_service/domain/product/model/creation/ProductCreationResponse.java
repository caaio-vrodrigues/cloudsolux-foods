package com.cloudsolux.foods.inventory_service.domain.product.model.creation;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;

public interface ProductCreationResponse extends ProductDTOFactoryPort {
 
  ProductResponse toProductResponse(Product product, Inventory inventory);
}