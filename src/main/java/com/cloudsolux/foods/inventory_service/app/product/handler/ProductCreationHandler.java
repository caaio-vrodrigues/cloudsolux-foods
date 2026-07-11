package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.inventory_service.app.inventory.handler.InventoryCreationHandler;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.model.ProductAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactory;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationResponse;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCreationHandler {

  private final ProductAdaptersGetter adapters;
  private final InventoryCreationHandler inventoryHandler;

  @Transactional
  public ProductResponse create(ProductCreationCommand command) {
    ProductValidation requestValidator = (ProductValidation) adapters
      .getValidator(command.getRequestValidationKey());
    requestValidator.validateCreationRequest(command);

    ProductFactory productFactory = (ProductFactory) adapters
      .getProductFactory(command.getProductCreationKey());
    Product product = productFactory.create(command);

    ProductPersistence persistence = (ProductPersistence) adapters
      .getPersistence(command.getProductSavingKey());
    persistence.save(product);

    Inventory inventory = inventoryHandler
      .create(command.toInventoryCreationCommand(null));

    ProductCreationResponse responseFactory = (ProductCreationResponse) adapters
      .getProductDTOFactory(command.getResponseCreationKey());

    return responseFactory.toProductResponse(product, inventory);
  }
}