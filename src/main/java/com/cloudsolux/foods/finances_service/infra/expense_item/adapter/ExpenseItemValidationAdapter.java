package com.cloudsolux.foods.finances_service.infra.expense_item.adapter;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidArgumentException;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidation;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class ExpenseItemValidationAdapter implements ExpenseItemValidation {

  private final ProductValidation productValidator;

  @Override
  public ExpenseItemValidationKey getKey() {
    return ExpenseItemValidationKey.EXPENSE_ITEM_CREATION_VALIDATION;
  }

  @Override
  public void validateProduct(Long productId) {
    ExpenseItemValidationAux
      .validatePositive(productId, "productId");

    boolean existsById = productValidator.validateExistenceById(productId);

    if(!existsById) 
      throw new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .notFoundMsg("Product", productId));
  }
}
