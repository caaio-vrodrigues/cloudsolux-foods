package com.cloudsolux.foods.finances_service.domain.expense.model.creation;

import java.util.List;

import com.cloudsolux.foods.finances_service.domain.expense.Expense;
import com.cloudsolux.foods.finances_service.domain.expense.command.ExpenseCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;

public interface ExpenseCreation extends ExpenseCreationPort {
 
  Expense create(ExpenseCreationCommand command, Long id, List<ExpenseItem> items);
}