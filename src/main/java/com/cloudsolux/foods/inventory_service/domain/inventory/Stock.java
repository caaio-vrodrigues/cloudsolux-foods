package com.cloudsolux.foods.inventory_service.domain.inventory;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;

public final class Stock {

  private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;
	
	private Stock(StockBuilder builder) {
		InventoryValidationAux.validatePositiveBigDecimal(builder.amount, "amount");
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

		if(incoming.getUnitOfMeasure() != unitOfMeasure)
			throw new InventoryInvalidArgumentException(GlobalMsgCreator.invalidUnitOfMeasureMsg(
				"Stock", incoming.getUnitOfMeasure(), unitOfMeasure));

    InventoryValidationAux.validatePositiveBigDecimal(
			incoming.amount, "amount");

		return Stock.builder()
			.amount(amount.add(incoming.amount))
			.unitOfMeasure(unitOfMeasure)
			.build();
	}
	
	public Stock subtract(Stock outgoing) {
		InventoryValidationAux.validateArgument(outgoing, "Stock");

		if(outgoing.getUnitOfMeasure() != unitOfMeasure)
			throw new InventoryInvalidArgumentException(GlobalMsgCreator.invalidUnitOfMeasureMsg(
				"Stock", outgoing.getUnitOfMeasure(), unitOfMeasure));

		InventoryValidationAux.validatePositiveBigDecimal(
			outgoing.amount, "amount");

		return Stock.builder()
			.amount(amount.subtract(outgoing.amount))
			.unitOfMeasure(unitOfMeasure)
			.build();
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Stock other)) return false;
		return amount.equals(other.amount) && 
			unitOfMeasure.equals(other.unitOfMeasure);
	}
	
	public int hashCode() {
		return Objects.hash(amount, unitOfMeasure);
	}

	public String toString() {
		return "Stock ['amount="+amount+"', 'unitOfMeasure="+unitOfMeasure+"']";
	}
}