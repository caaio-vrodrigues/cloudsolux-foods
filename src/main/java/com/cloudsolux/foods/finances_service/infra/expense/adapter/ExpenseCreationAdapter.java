package com.cloudsolux.foods.finances_service.infra.expense.adapter;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense.Expense;
import com.cloudsolux.foods.finances_service.domain.expense.command.ExpenseCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreation;
import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;

@Component
public final class ExpenseCreationAdapter implements ExpenseCreation {

  @Override
  public ExpenseCreationKey getKey() {
    return ExpenseCreationKey.EXPENSE_CREATION;
  }

  @Override
  public Expense create(
    ExpenseCreationCommand command, Long id, List<ExpenseItem> items
  ) {
    ExpenseValidationAux.validateArgument(command, "ExpenseCreationCommand");
    ExpenseValidationAux.validatePositive(id, "id");
    ExpenseValidationAux.validateList(items, "ExpenseItem");

    return Expense.builder()
      .id(id)
      .purchaseDate(Instant.now())
      .description(command.getDescription())
      .items(items)
      .build();
  }
}