package com.cloudsolux.foods.inventory_service.infra.product.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductMsgCreator;

@Component
public class ProductResponseGenarator {
  
  public ProductResponse toProductResponse(
    Product product, 
    Inventory inventory
  ) {
    List<String> nullArguments = new ArrayList<>();
    if(product == null) nullArguments.add("Product");
    if(inventory == null) nullArguments.add("Inventory");
    if(!nullArguments.isEmpty()) {
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ProductEntity", nullArguments));
    }
    if(product.getId() != inventory.getCatalogId()) {
      throw new ProductInvalidArgumentException(ProductMsgCreator
        .unrelatedDomainsOnResponseCreation(
          product.getId(), 
          inventory.getCatalogId()
        ));
    }
    return ProductResponse.builder()
      .id(product.getId())
      .name(product.getName())
      .model(product.getModel())
      .brand(product.getBrand())
      .amount(inventory.getStock().getAmount())
      .unitOfMeasure(inventory.getStock().getUnitOfMeasure())
      .build();
  }
}