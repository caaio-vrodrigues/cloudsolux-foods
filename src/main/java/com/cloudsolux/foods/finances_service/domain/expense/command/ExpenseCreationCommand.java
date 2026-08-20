package com.cloudsolux.foods.finances_service.domain.expense.command;

import java.util.List;

import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;

public final class ExpenseCreationCommand {

  private final List<ExpenseItemCreationCommand> items;
  private final String description;

  private ExpenseCreationCommand(ExpenseCreationCommandBuilder builder) {
    ExpenseValidationAux.validateList(builder.items, "List<ExpenseItemCreationCommand>");
    ExpenseValidationAux.validateString(builder.description, "description");
    items = builder.items;
    description = builder.description;
  }

  public static class ExpenseCreationCommandBuilder {
    private List<ExpenseItemCreationCommand> items;
    private String description;

    public ExpenseCreationCommandBuilder items(List<ExpenseItemCreationCommand> items) {
      this.items = List.copyOf(items);
      return this;
    }

    public ExpenseCreationCommandBuilder description(String description) {
      this.description = description;
      return this;
    }

    public ExpenseCreationCommand build() {
      return new ExpenseCreationCommand(this);
    }
  }

  public static ExpenseCreationCommandBuilder builder() {
    return new ExpenseCreationCommandBuilder();
  }

  public ExpenseCreationKey getFactoryKey() {
    return ExpenseCreationKey.EXPENSE_CREATION;
  }

  public List<ExpenseItemCreationCommand> getItems() {
    return List.copyOf(items);
  }

  public String getDescription() {
    return description;
  }
}