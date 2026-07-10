package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.stereotype.Service;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreateCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreation;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCreationHandler {

  private final ProductAdaptersGetter adapters;

  public ProductResponse create(ProductCreateCommand command) {
    ProductValidation requestValidator = (ProductValidation) adapters
      .getValidator(command.getRequestValidationKey());
    requestValidator.validateCreationRequest(command);

    ProductCreation productFactory = (ProductCreation) adapters
      .getCreator(command.getProductCreationKey());
    Product product = productFactory.create(command);

    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}