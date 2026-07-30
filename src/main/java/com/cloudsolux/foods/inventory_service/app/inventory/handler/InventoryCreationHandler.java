package com.cloudsolux.foods.inventory_service.app.inventory.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactory;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistence;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.infra.inventory.util.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.infra.inventory.util.InventoryCommandGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryCreationHandler {

  private final InventoryCommandGenerator commandGenerator;
  private final InventoryAdaptersGetter adapters;

  @Transactional
  public Inventory create(ProductCreationCommand productCommand, Long id) {
    InventoryValidationAux
      .validateArgument(productCommand, "ProductCreationCommand");
    InventoryValidationAux
      .validatePositiveLong(id, "id");
    InventoryValidationAux
      .validateDependency(commandGenerator, "InventoryCommandGenerator");
    InventoryValidationAux
      .validateDependency(adapters, "InventoryAdaptersGetter");

    InventoryCreationCommand command = commandGenerator
      .generateCreationCommand(productCommand, id);

    InventoryFactory factory = (InventoryFactory) adapters
      .getFactory(InventoryFactoryKey.INVENTORY_CREATION);
    InventoryValidationAux
      .validateDependency(factory, "InventoryAdaptersGetter");

    Inventory inventory = factory.create(command);

    InventoryPersistence persistence = (InventoryPersistence) adapters
      .getPersistence(InventoryPersistenceKey.INVENTORY_PERSISTENCE);
    InventoryValidationAux
      .validateDependency(persistence, "InventoryAdaptersGetter");

    persistence.save(inventory);
    return inventory;
  }
}