package com.cloudsolux.foods.inventory_service.infra.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Table(name="inventory")
@Entity
@Builder
@Getter
public final class InventoryEntity {
	
	@Version
	private Long version;

	@Include
	@Id
	@Column(name="id")
	private Long catalogId;
	
	@Embedded
	private StockEmbeddable stock;

	@Override
	public String toString() {
		return "InventoryEntity: ['catalogId="+catalogId+"', "+stock+"]";
	}
}