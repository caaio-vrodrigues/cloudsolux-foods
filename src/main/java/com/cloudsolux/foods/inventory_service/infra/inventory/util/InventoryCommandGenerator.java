package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;

@Component
public class InventoryCommandGenerator {

  public InventoryCreationCommand generateCreationCommand(
    ProductCreationCommand productCommand, Long id
  ) {
    return InventoryCreationCommand.builder()
      .id(id)
      .amount(productCommand.getAmount())
      .unitOfMeasure(productCommand.getUnitOfMeasure())
      .build();
  }
}