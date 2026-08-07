package com.cloudsolux.foods.inventory_service.infra.product.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;

@Component
public final class ProductResponseGenerator {
  
  public ProductResponse toProductResponse(
    Product product, Inventory inventory
  ) {
    ProductValidationAux.validateArgument(product, "Product");
    ProductValidationAux.validateArgument(inventory, "Inventory");
    ProductValidationAux.validateIdCorrelation(product.getId(), inventory.getCatalogId());

    return ProductResponse.builder()
      .id(product.getId())
      .name(product.getName())
      .model(product.getModel())
      .brand(product.getBrand())
      .amount(inventory.getAmount())
      .unitOfMeasure(inventory.getUnitOfMeasure())
      .build();
  }
}