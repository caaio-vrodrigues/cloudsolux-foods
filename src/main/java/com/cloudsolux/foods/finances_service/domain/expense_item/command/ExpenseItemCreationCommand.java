package com.cloudsolux.foods.finances_service.domain.expense_item.command;

import java.math.BigDecimal;

import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

public final class ExpenseItemCreationCommand {

  private final Long productId;
  private final BigDecimal price;
  private final BigDecimal amount;
  
  private ExpenseItemCreationCommand(ExpenseItemCreationCommandBuilder builder) {
    ExpenseItemValidationAux.validatePositive(builder.productId, "productId");
    ExpenseItemValidationAux.validatePositiveOrZero(builder.price, "price");
    ExpenseItemValidationAux.validatePositiveOrZero(builder.amount, "amount");
    productId = builder.productId;
    price = builder.price;
    amount = builder.amount;
  }

  public static class ExpenseItemCreationCommandBuilder {
    private Long productId;
    private BigDecimal price;
    private BigDecimal amount;

    public ExpenseItemCreationCommandBuilder productId(Long id) {
      productId = id;
      return this;
    }

    public ExpenseItemCreationCommandBuilder price(BigDecimal price) {
      this.price = price;
      return this;
    }

    public ExpenseItemCreationCommandBuilder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public ExpenseItemCreationCommand build() {
      return new ExpenseItemCreationCommand(this);
    }
  }

  public static ExpenseItemCreationCommandBuilder builder() {
    return new ExpenseItemCreationCommandBuilder();
  }

  public Long getProductId() {
    return productId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}