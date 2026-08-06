package com.cloudsolux.foods.inventory_service.domain.inventory;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;

public final class Inventory {
  private final Long catalogId;
	private final Stock stock;
	
	private Inventory(InventoryBuilder builder) {
		InventoryValidationAux.validatePositive(builder.catalogId, "catalogId");
		InventoryValidationAux.validateArgument(builder.stock, "Stock");
		catalogId = builder.catalogId;
		stock = builder.stock;
	}
	
	public static class InventoryBuilder {
		private Long catalogId;
		private Stock stock;
		
		public InventoryBuilder catalogId(Long id) {
			catalogId = id;
			return this;
		}
		
		public InventoryBuilder stock(Stock stock) {
			this.stock = stock;
			return this;
		}
		
		public Inventory build() {
			return new Inventory(this);
		}
	}
	
	public static InventoryBuilder builder() {
		return new InventoryBuilder();
	}
	
	public Long getCatalogId() {
		return catalogId;
	}
	
	public UnitOfMeasure getUnitOfMeasure() {
		return stock.getUnitOfMeasure();
	}
	
	public BigDecimal getAmount() {
		return stock.getAmount();
	}
	
	public Inventory receiveStock(Stock incoming) {
		return Inventory.builder()
			.catalogId(catalogId)
			.stock(stock.add(incoming))
			.build();
	}
	
	public Inventory dispatchStock(Stock outgoing) {
		return Inventory.builder()
			.catalogId(catalogId)
			.stock(stock.subtract(outgoing))
			.build();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Inventory other)) return false;
		return Objects.equals(catalogId, other.catalogId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(catalogId);
	}

	@Override
	public String toString() {
		return "Inventory: ['catalogId="+catalogId+"']";
	}
}