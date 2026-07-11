package com.cloudsolux.foods.inventory_service.infra.product.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationResponse;

@Component
public class ProductCreationResponseAdapter implements ProductCreationResponse {

  @Override
  public ProductDTOFactoryKey getKey() {
    return ProductDTOFactoryKey.CREATE_RESPONSE;
  }

  @Override
  public ProductResponse toProductResponse(Product product, Inventory inventory) {
    throw new UnsupportedOperationException("Unimplemented method 'toProductResponse'");
  }
}