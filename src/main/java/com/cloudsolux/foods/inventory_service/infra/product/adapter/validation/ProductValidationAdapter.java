package com.cloudsolux.foods.inventory_service.infra.product.adapter.validation;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductAlreadyExistsException;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

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
    ProductValidationAux.validateDependency(repo, "ProductRepo");

    boolean existsByConstraint = repo.existsByNameAndModelAndBrand(
      command.getName(), command.getModel(), command.getBrand()
    );

    if(existsByConstraint) throw new ProductAlreadyExistsException(
      ProductMsgCreator.uniquenessViolationMsg(
        command.getName(), command.getModel(), command.getBrand()
      ));
  }
}