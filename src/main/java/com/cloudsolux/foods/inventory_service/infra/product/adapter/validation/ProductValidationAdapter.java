package com.cloudsolux.foods.inventory_service.infra.product.adapter.validation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;

@Component
public class ProductValidationAdapter implements ProductValidation {

  @Override
  public ProductValidationKey getKey() {
    return ProductValidationKey.VALIDATE_CREATION_REQUEST;
  }

  @Override
  public void validateCreationRequest(ProductCreationCommand command) {
    throw new UnsupportedOperationException("Unimplemented method 'validateCreationRequest'");
  }
}