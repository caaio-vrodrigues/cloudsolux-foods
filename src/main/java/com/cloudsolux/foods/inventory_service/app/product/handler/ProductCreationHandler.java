package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.stereotype.Service;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreateCommand;

@Service
public class ProductCreationHandler {

  public ProductResponse create(ProductCreateCommand command) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}