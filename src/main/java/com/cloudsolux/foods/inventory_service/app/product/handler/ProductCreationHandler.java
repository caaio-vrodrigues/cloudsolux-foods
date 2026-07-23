package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.inventory_service.app.inventory.handler.InventoryCreationHandler;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductResponseGenarator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCreationHandler {

  private final ProductAdaptersGetter adapters;
  private final IdControlGeneratorHandler idGenerator;
  private final InventoryCreationHandler inventoryHandler;
  private final ProductResponseGenarator reponseGenerator;

  @Transactional
  public ProductResponse create(ProductCreationCommand command) {
    ProductValidationAux
      .validateArgument(command, "ProductCreationCommand");
    ProductValidationAux
      .validateDependency(adapters, "ProductAdaptersGetter");
    ProductValidationAux
      .validateDependency(idGenerator, "IdControlGeneratorHandler");
    ProductValidationAux
      .validateDependency(inventoryHandler, "InventoryCreationHandler");
    ProductValidationAux
      .validateDependency(reponseGenerator, "ProductResponseGenarator");

    ProductValidation validator = (ProductValidation) adapters
      .getValidator(command.getRequestValidationKey());
    ProductValidationAux
      .validateDependency(validator, "ProductAdaptersGetter");
    validator.validateProductUniqueness(command);

    Long id = idGenerator.generateId(command.getIdControlKey());

    ProductFactory productFactory = (ProductFactory) adapters
      .getProductFactory(command.getProductCreationKey());
    ProductValidationAux
      .validateDependency(productFactory, "ProductAdaptersGetter");
    Product product = productFactory.create(command, id);

    ProductPersistence persistence = (ProductPersistence) adapters
      .getPersistence(command.getProductSavingKey());
    ProductValidationAux
      .validateDependency(persistence, "ProductAdaptersGetter");
    persistence.save(product);

    Inventory inventory = inventoryHandler.create(command, id);
    
    return reponseGenerator.toProductResponse(product, inventory);
  }
}