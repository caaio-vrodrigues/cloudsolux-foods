package com.cloudsolux.foods.finances_service.domain.expense_item.model.creation;

import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;
import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;

public interface ExpenseItemCreation extends ExpenseItemCreationPort {
  
  ExpenseItem create(ExpenseItemCreationCommand command, Long id);
}