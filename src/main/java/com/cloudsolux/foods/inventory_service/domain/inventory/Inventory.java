package com.cloudsolux.foods.inventory_service.domain.inventory;

import java.util.Objects;

import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;

public class Inventory {
  private final Long catalogId;
	private Stock stock;
	
	private Inventory(InventoryBuilder builder) {
		InventoryValidationAux.validatePositiveLong(
			builder.catalogId, "catalogId");

		InventoryValidationAux.validateArgument(
			builder.stock, "Stock");

		catalogId = builder.catalogId;
		this.stock = builder.stock;
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
	
	public Stock getStock() {
		return stock;
	}
	
	public void receiveStock(Stock incoming) {
		InventoryValidationAux.validateArgument(incoming, "Stock");
		stock = stock.add(incoming);
	}
	
	public void dispatchStock(Stock outgoing) {
		InventoryValidationAux.validateArgument(outgoing, "Stock");
		stock = stock.subtract(outgoing);
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Inventory other)) return false;
		return catalogId.equals(other.catalogId);
	}
	
	public int hashCode() {
		return Objects.hash(catalogId);
	}

	public String toString() {
		return "Inventory ['catalogId="+catalogId+"', "+stock+"]";
	}
}