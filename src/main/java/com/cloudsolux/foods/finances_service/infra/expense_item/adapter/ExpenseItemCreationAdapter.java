package com.cloudsolux.foods.finances_service.infra.expense_item.adapter;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;
import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseValue;
import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreation;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

@Component
public final class ExpenseItemCreationAdapter implements ExpenseItemCreation {

  @Override
  public ExpenseItemCreationKey getKey() {
    return ExpenseItemCreationKey.EXPENSE_ITEM_CREATION;
  }

  @Override
  public ExpenseItem create(ExpenseItemCreationCommand command, Long id) {
    ExpenseItemValidationAux.validateArgument(command, "ExpenseItemCreationCommand");
    ExpenseItemValidationAux.validatePositive(id, "id");

    ExpenseValue expenseValue = ExpenseValue.builder()
      .amount(command.getAmount())
      .price(command.getPrice())
      .build();

    return ExpenseItem.builder()
      .id(id)
      .productId(command.getProductId())
      .expenseValue(expenseValue)
      .build();
  }
  
}