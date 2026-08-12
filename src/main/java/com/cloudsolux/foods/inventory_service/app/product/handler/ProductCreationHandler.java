package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.inventory_service.app.inventory.handler.InventoryCreationHandler;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.command.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductResponseGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCreationHandler {

  private final ProductAdaptersGetter adapters;
  private final IdControlGeneratorHandler idGenerator;
  private final InventoryCreationHandler inventoryHandler;
  private final ProductResponseGenerator responseGenerator;

  @Transactional
  public ProductResponse create(
    ProductCreationCommand productCommand, InventoryCreationCommand inventoryCommand
  ) {
    ProductValidationAux.validateArgument(productCommand, "ProductCreationCommand");

    ProductValidation validator = (ProductValidation) adapters
      .getValidator(productCommand.getRequestValidationKey());
    ProductValidationAux.validateDependencyResult(
      validator, "ProductAdaptersGetter", "ProductValidation");

    validator.validateProductUniqueness(productCommand);
    Long id = idGenerator.generateId(productCommand.getCatalogIdKey());

    ProductFactory factory = (ProductFactory) adapters
      .getProductFactory(productCommand.getProductCreationKey());
    ProductValidationAux.validateDependencyResult(
      factory, "ProductAdaptersGetter", "ProductFactory");

    Product product = factory.create(productCommand, id);

    ProductPersistence persistence = (ProductPersistence) adapters
      .getPersistence(productCommand.getProductSavingKey());
    ProductValidationAux.validateDependencyResult(
      persistence, "ProductAdaptersGetter", "ProductPersistence");

    persistence.save(product);
    Inventory inventory = inventoryHandler.create(inventoryCommand, id);
    return responseGenerator.toProductResponse(product, inventory);
  }
}