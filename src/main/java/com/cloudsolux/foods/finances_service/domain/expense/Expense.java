package com.cloudsolux.foods.finances_service.domain.expense;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;

public final class Expense {

  private final Long id;
	private final Instant purchaseDate;
	private final List<ExpenseItem> items;
	private final String description;

  private Expense(ExpenseBuilder builder) {
    ExpenseValidationAux.validatePositive(builder.id, "id");
    ExpenseValidationAux.validateInstant(builder.purchaseDate, "purchaseDate");
    ExpenseValidationAux.validateList(builder.items, "items");
    ExpenseValidationAux.validateString(builder.description, "description");
    id = builder.id;
    purchaseDate = builder.purchaseDate;
    items = builder.items;
    description = builder.description;
  }

  public static class ExpenseBuilder {
    private Long id;
    private Instant purchaseDate;
    private List<ExpenseItem> items;
    private String description;

    public ExpenseBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public ExpenseBuilder purchaseDate(Instant purchaseDate) {
      this.purchaseDate = purchaseDate;
      return this;
    }

    public ExpenseBuilder items(List<ExpenseItem> items) {
      this.items = List.copyOf(items);
      return this;
    }

    public ExpenseBuilder description(String description) {
      this.description = description;
      return this;
    }

    public Expense build() {
      return new Expense(this);
    }
  }

  public static ExpenseBuilder builder() {
    return new ExpenseBuilder();
  }

  public Long getId() {
    return id;
  }

  public Instant getPurchaseDate() {
    return purchaseDate;
  }

  public List<ExpenseItem> getItems() {
    return List.copyOf(items);
  }

  public String getDescription() {
    return description;
  }

  @Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Expense other)) return false;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

  @Override
  public String toString() {
    return "Expense: ['id="+id+"', 'purchaseDate="+purchaseDate+"', 'items="+items+"', 'description="+description+"']";
  }
}