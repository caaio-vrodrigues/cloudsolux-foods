package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.creation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryCreationCommandFactory;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;

@Component
public class InventoryCreationCommandFactoryAdapter implements InventoryCreationCommandFactory {

  @Override
  public InventoryFactoryKey getKey() {
    return InventoryFactoryKey.INVENTORY_CREATION_COMMAND_CREATION;
  }

  @Override
  public InventoryCreationCommand create(
    ProductCreationCommand productCommand, Long id
  ) {
    return InventoryCreationCommand.builder()
      .id(id)
      .amount(productCommand.getAmount())
      .unitOfMeasure(productCommand.getUnitOfMeasure())
      .build();
  }
}