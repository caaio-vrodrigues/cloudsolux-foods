package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;

@Component
public final class InventoryCommandGenerator {

  public InventoryCreationCommand generateCreationCommand(
    ProductCreationCommand productCommand, Long id
  ) {
    InventoryValidationAux.validateArgument(
      productCommand, "ProductCreationCommand");
      
    InventoryValidationAux.validateArgument(id, "id");

    return InventoryCreationCommand.builder()
      .id(id)
      .amount(productCommand.getAmount())
      .unitOfMeasure(productCommand.getUnitOfMeasure())
      .build();
  }
}