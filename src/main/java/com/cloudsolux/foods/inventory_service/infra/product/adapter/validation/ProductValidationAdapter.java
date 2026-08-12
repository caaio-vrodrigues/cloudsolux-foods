package com.cloudsolux.foods.inventory_service.infra.product.adapter.validation;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductDataAccessException;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.repo.ProductRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class ProductValidationAdapter implements ProductValidation {

  private final ProductRepo repo;

  @Override
  public ProductValidationKey getKey() {
    return ProductValidationKey.VALIDATE_CREATION_REQUEST;
  }

  @Override
  public void validateProductUniqueness(ProductCreationCommand command) {
    ProductValidationAux.validateArgument(command, "ProductCreationCommand");

    boolean existsByConstraint;

    try {
      existsByConstraint = repo
        .existsByNameAndModelAndBrand(
          command.getName(), command.getModel(), command.getBrand());
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("Product")+". {}", 
        e.getMessage(), 
        e
      );
      throw new ProductDataAccessException(GlobalMsgCreator
        .accessFailureMsg("Product"));
    }

    ProductValidationAux.validateDependencyResult(
      existsByConstraint, "ProductRepo", "boolean");

    ProductValidationAux.validateUniqueness(
      existsByConstraint, command.getName(), command.getModel(), command.getBrand());
  }
}