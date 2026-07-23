package com.cloudsolux.foods.inventory_service.infra.inventory.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Table(name="inventory")
@Entity
@Builder
@Getter
public final class InventoryEntity {
	
	@Version
	private Long version;

	@Id
	private Long catalogId;
	
	@Embedded @Valid
	private StockEmbeddable stock;

	@Override
	public String toString() {
		return "InventoryEntity ['catalogId="+catalogId+"', "+stock+"]";
	}
}