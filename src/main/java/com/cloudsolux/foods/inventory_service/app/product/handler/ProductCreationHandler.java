package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.util.IdGenerator;
import com.cloudsolux.foods.inventory_service.app.inventory.handler.InventoryCreationHandler;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductResponseGenarator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCreationHandler {

  private final ProductAdaptersGetter adapters;
  private final InventoryCreationHandler inventoryHandler;
  private final IdGenerator idGenerator;
  private final ProductResponseGenarator reponseGenerator;

  @Transactional
  public ProductResponse create(ProductCreationCommand command) {
    ProductValidation requestValidator = (ProductValidation) adapters
      .getValidator(command.getRequestValidationKey());
    requestValidator.validateProductUniqueness(command);

    Long id = idGenerator.getId(IdControlKey.CATALOG_ID);

    ProductFactory productFactory = (ProductFactory) adapters
      .getProductFactory(command.getProductCreationKey());
    Product product = productFactory.create(command, id);

    ProductPersistence persistence = (ProductPersistence) adapters
      .getPersistence(command.getProductSavingKey());
    persistence.save(product);

    Inventory inventory = inventoryHandler.create(command, id);
    return reponseGenerator.toProductResponse(product, inventory);
  }
}