package com.cloudsolux.foods.finances_service.domain.expense.command;

import java.time.Instant;
import java.util.List;

import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;

public final class ExpenseCreationCommand {

  private final Instant purchaseDate;
  private final List<ExpenseItemCreationCommand> items;
  private final String description;

  private ExpenseCreationCommand(ExpenseCreationCommandBuilder builder) {
    ExpenseValidationAux.validateInstant(builder.purchaseDate, "purchaseDate");
    ExpenseValidationAux.validateList(builder.items, "List<ExpenseItemCreationCommand>");
    ExpenseValidationAux.validateString(builder.description, "description");
    purchaseDate = builder.purchaseDate;
    items = builder.items;
    description = builder.description;
  }

  public static class ExpenseCreationCommandBuilder {
    private Instant purchaseDate;
    private List<ExpenseItemCreationCommand> items;
    private String description;

    public ExpenseCreationCommandBuilder purchaseDate(Instant purchaseDate) {
      this.purchaseDate = purchaseDate;
      return this;
    }

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

  public Instant getPurchaseDate() {
    return purchaseDate;
  }

  public List<ExpenseItemCreationCommand> getItems() {
    return List.copyOf(items);
  }

  public String getDescription() {
    return description;
  }
}