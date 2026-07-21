package com.cloudsolux.foods.inventory_service.domain.inventory;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;

public class Stock {

  private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;
	
	private Stock(StockBuilder builder) {
		amount = builder.amount;
		unitOfMeasure = builder.unitOfMeasure;
	}
	
	public static class StockBuilder {
		private BigDecimal amount;
		private UnitOfMeasure unitOfMeasure;
		
		public StockBuilder amount(BigDecimal amount) {
			if(!(amount instanceof BigDecimal)) {
				String receivedClassName = amount != null ? 
					amount.getClass().getSimpleName() : "null";
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("BigDecimal", receivedClassName));
			}
			if(amount.compareTo(BigDecimal.ZERO) < 0) {
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.positiveMsg("Stock", "amount", amount));
			}
			this.amount = amount;
			return this;
		}
		
		public StockBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
			if(!(unitOfMeasure instanceof UnitOfMeasure)) {
				String receivedClassName = unitOfMeasure != null ? 
					unitOfMeasure.getClass().getSimpleName() : "null";
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("UnitOfMeasure", receivedClassName));
			}
			this.unitOfMeasure = unitOfMeasure;
			return this;
		}
		
		public Stock build() {
			if(amount == null)
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.nullFieldValueMsg("Stock", "amount"));
			if(unitOfMeasure == null)
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.nullFieldValueMsg("Stock", "unitOfMeasure"));
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
		if(!(incoming instanceof Stock)) {
			String receivedClassName = incoming != null ? 
				incoming.getClass().getSimpleName() : "null";
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.invalidClassMsg("Stock", receivedClassName));
		}
		if(incoming.getUnitOfMeasure() != unitOfMeasure) {
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.invalidUnitOfMeasureMsg("Stock", incoming.getUnitOfMeasure(), unitOfMeasure));
		}
    if(incoming.getAmount().compareTo(BigDecimal.ZERO) < 0) {
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.positiveMsg("Stock", "amount", incoming.getAmount()));
    }
		return Stock.builder()
			.amount(amount.add(incoming.amount))
			.unitOfMeasure(unitOfMeasure)
			.build();
	}
	
	public Stock subtract(Stock outgoing) {
		if(!(outgoing instanceof Stock)) {
			String receivedClassName = outgoing != null ? 
				outgoing.getClass().getSimpleName() : "null";
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.invalidClassMsg("Stock", receivedClassName));
		}
		if(outgoing.getUnitOfMeasure() != unitOfMeasure) {
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.invalidUnitOfMeasureMsg("Stock", outgoing.getUnitOfMeasure(), unitOfMeasure));
		}
		if(amount.compareTo(outgoing.amount) < 0) {
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.insuficcientAmount("Stock", outgoing.amount, amount));
		}
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