package com.cloudsolux.foods.inventory_service.domain.product.model.validation;

import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreateCommand;

public interface ProductValidation extends ProductValidationPort {
 
  void validateCreationRequest(ProductCreateCommand requestDTO);
}