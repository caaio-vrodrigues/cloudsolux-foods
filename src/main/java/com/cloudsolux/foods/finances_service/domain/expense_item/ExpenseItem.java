package com.cloudsolux.foods.finances_service.domain.expense_item;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

public final class ExpenseItem {

  private final Long id;
	private final Long productId;
	private final ExpenseValue expenseValue;
  
  private ExpenseItem(ExpenseItemBuilder builder) {
    ExpenseItemValidationAux.validatePositiveLong(builder.id, "id");
    ExpenseItemValidationAux.validatePositiveLong(builder.productId, "productId");
    ExpenseItemValidationAux.validateArgument(builder.expenseValue, "ExpenseValue");
    id = builder.id;
		productId = builder.productId;
    expenseValue = builder.expenseValue;
  }

  public static class ExpenseItemBuilder {
    private Long id;
		private Long productId;
    private ExpenseValue expenseValue;

    public ExpenseItemBuilder id(Long id) {
			this.id =id;
			return this;
		}
		
		public ExpenseItemBuilder productId(Long productId) {
			this.productId = productId;
			return this;
		}

    public ExpenseItemBuilder expenseValue(ExpenseValue expenseValue) {
			this.expenseValue = expenseValue;
			return this;
		}
		
		public ExpenseItem build() {
			return new ExpenseItem(this);
		}
  }

  public static ExpenseItemBuilder builder() {
    return new ExpenseItemBuilder();
  }

  public Long getId() {
    return id;
  }

  public Long getProductId() {
    return productId;
  }

  public BigDecimal getPrice() {
    return expenseValue.getPrice();
  }

  public BigDecimal getAmount() {
    return expenseValue.getAmount();
  }

  public ExpenseItem increasePrice(BigDecimal price) {
    ExpenseItemValidationAux.validatePositiveBigDecimal(price, "price");
    return ExpenseItem.builder()
      .id(id)
      .productId(productId)
      .expenseValue(expenseValue.increasePrice(price))
      .build();
  }

  public ExpenseItem decreasePrice(BigDecimal price) {
    ExpenseItemValidationAux.validatePositiveBigDecimal(price, "price");
    return ExpenseItem.builder()
      .id(id)
      .productId(productId)
      .expenseValue(expenseValue.decreasePrice(price))
      .build();
  }

  public ExpenseItem increaseAmount(BigDecimal amount) {
    ExpenseItemValidationAux.validatePositiveBigDecimal(amount, "amount");
    return ExpenseItem.builder()
      .id(id)
      .productId(productId)
      .expenseValue(expenseValue.increaseAmount(amount))
      .build();
  }

  public ExpenseItem decreaseAmount(BigDecimal amount) {
    ExpenseItemValidationAux.validatePositiveBigDecimal(amount, "amount");
    return ExpenseItem.builder()
      .id(id)
      .productId(productId)
      .expenseValue(expenseValue.decreaseAmount(amount))
      .build();
  }

  @Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof ExpenseItem other)) return false;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

  @Override
	public String toString() {
		return "ExpenseItem: ['id="+id+"', 'productId="+productId+"', "+expenseValue+"]";
	}
}