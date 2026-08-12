package com.cloudsolux.foods.finances_service.domain.expense_item;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

public final class ExpenseValue {

  private final BigDecimal price;
	private final BigDecimal amount;
  
  private ExpenseValue(ExpenseValueBuilder builder) {
    ExpenseItemValidationAux.validatePositiveOrZero(builder.price, "price");
    ExpenseItemValidationAux.validatePositiveOrZero(builder.amount, "amount");
    price = builder.price;
    amount = builder.amount;
  }

  public static class ExpenseValueBuilder {
    private BigDecimal price;
	  private BigDecimal amount;

    public ExpenseValueBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public ExpenseValueBuilder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

    public ExpenseValue build() {
      return new ExpenseValue(this);
    }
  }

  public static ExpenseValueBuilder builder() {
    return new ExpenseValueBuilder();
  }

  public ExpenseValue increasePrice(BigDecimal price) {
    ExpenseItemValidationAux.validatePositiveOrZero(price, "price");

    return ExpenseValue.builder()
      .amount(amount)
      .price(this.price.add(price))
      .build();
  }

  public ExpenseValue decreasePrice(BigDecimal price) {
    ExpenseItemValidationAux.validatePositiveOrZero(price, "price");

    ExpenseItemValidationAux.validateUnderZeroResult(
      this.price, price, "price", "price"
    );

    return ExpenseValue.builder()
      .amount(amount)
      .price(this.price.subtract(price))
      .build();
  }

  public ExpenseValue increaseAmount(BigDecimal amount) {
    ExpenseItemValidationAux.validatePositiveOrZero(amount, "amount");
    
    return ExpenseValue.builder()
      .amount(this.amount.add(amount))
      .price(price)
      .build();
  }

  public ExpenseValue decreaseAmount(BigDecimal amount) {
    ExpenseItemValidationAux.validatePositiveOrZero(amount, "amount");

    ExpenseItemValidationAux.validateUnderZeroResult(
      this.amount, amount, "amount", "amount"
    );

    return ExpenseValue.builder()
      .amount(this.amount.subtract(amount))
      .price(price)
      .build();
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ExpenseValue other)) return false;
    return price.compareTo(other.price) == 0
      && amount.compareTo(other.amount) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price.stripTrailingZeros(), amount.stripTrailingZeros());
  }

  @Override
  public String toString() {
    return "ExpenseValue: ['price="+price+"', 'amount="+amount+"']";
  }
}