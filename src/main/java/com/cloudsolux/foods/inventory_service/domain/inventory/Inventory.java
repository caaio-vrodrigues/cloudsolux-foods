package com.cloudsolux.foods.inventory_service.domain.inventory;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;

public class Inventory {
  private final Long catalogId;
	private Stock stock;
	
	private Inventory(InventoryBuilder builder) {
		catalogId = builder.catalogId;
		this.stock = builder.stock;
	}
	
	public static class InventoryBuilder {
		private Long catalogId;
		private Stock stock;
		
		public InventoryBuilder catalogId(Long id) {
			if(id == null) {
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.nullFieldValueMsg("Inventory", "catalogId"));
			}
			if(id < 1) {
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.positiveMsg("Inventory", "id", BigDecimal.valueOf(id)));
			}
			catalogId = id;
			return this;
		}
		
		public InventoryBuilder stock(Stock stock) {
			if(stock == null) {
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.nullFieldValueMsg("Inventory", "stock"));
			}
			this.stock = stock;
			return this;
		}
		
		public Inventory build() {
			if(catalogId == null)
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.nullFieldValueMsg("Inventory", "catalogId"));
			if(stock == null)
				throw new InventoryInvalidArgumentException(GlobalMsgCreator
					.nullFieldValueMsg("Inventory", "stock"));
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
		if(incoming == null) {
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.nullFieldValueMsg("Inventory", "incoming"));
		}
		stock = stock.add(incoming);
	}
	
	public void dispatchStock(Stock outgoing) {
		if(outgoing == null) {
			throw new InventoryInvalidArgumentException(GlobalMsgCreator
				.nullFieldValueMsg("Inventory", "outgoing"));
		}
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

	@Override
	public String toString() {
		return "Inventory ['catalogId="+catalogId+"', "+stock+"]";
	}
}