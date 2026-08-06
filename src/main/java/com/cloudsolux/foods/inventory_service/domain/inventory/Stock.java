package com.cloudsolux.foods.inventory_service.domain.inventory;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;

public final class Stock {

  private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;
	
	private Stock(StockBuilder builder) {
		InventoryValidationAux.validatePositiveOrZero(builder.amount, "amount");
		InventoryValidationAux.validateArgument(builder.unitOfMeasure, "UnitOfMeasure");
		amount = builder.amount;
		unitOfMeasure = builder.unitOfMeasure;
	}
	
	public static class StockBuilder {
		private BigDecimal amount;
		private UnitOfMeasure unitOfMeasure;
		
		public StockBuilder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}
		
		public StockBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
			this.unitOfMeasure = unitOfMeasure;
			return this;
		}
		
		public Stock build() {
			return new Stock(this);
		}
	}

	public static StockBuilder builder() {
		return new StockBuilder();
	}
	
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public Stock add(Stock incoming) {
		InventoryValidationAux.validateArgument(incoming, "Stock");
		InventoryValidationAux.validatePositive(incoming.amount, "incoming.amount");

		InventoryValidationAux.validateUnitOfMeasure(
			unitOfMeasure, 
			incoming.unitOfMeasure, 
			"unitOfMeasure", 
			"incoming.unitOfMeasure"
		);

		return Stock.builder()
			.amount(amount.add(incoming.amount))
			.unitOfMeasure(unitOfMeasure)
			.build();
	}
	
	public Stock subtract(Stock outgoing) {
		InventoryValidationAux.validateArgument(outgoing, "Stock");
		InventoryValidationAux.validatePositive(outgoing.amount, "outgoing.amount");
		
		InventoryValidationAux.validateUnderZeroResult(
			amount, 
			outgoing.amount, 
			"amount", 
			"outgoing.amount"
		);

		InventoryValidationAux.validateUnitOfMeasure(
			unitOfMeasure, 
			outgoing.unitOfMeasure, 
			"unitOfMeasure", 
			"outgoing.unitOfMeasure"
		);
		
		return Stock.builder()
			.amount(amount.subtract(outgoing.amount))
			.unitOfMeasure(unitOfMeasure)
			.build();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Stock other)) return false;
		return amount.compareTo(other.amount) == 0 && 
			Objects.equals(unitOfMeasure, other.unitOfMeasure);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount.stripTrailingZeros(), unitOfMeasure);
	}

	@Override
	public String toString() {
		return "Stock: ['amount="+amount+"', 'unitOfMeasure="+unitOfMeasure+"']";
	}
}