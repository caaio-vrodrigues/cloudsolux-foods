package com.cloudsolux.foods.inventory_service.infra.inventory.entity;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class StockEmbeddable {
  
  @Column(name="amount", nullable=false, precision=19, scale=4)
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="unit_measure", nullable=false)
	private UnitOfMeasure unitOfMeasure;

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof StockEmbeddable other)) return false;
		return amount.compareTo(other.amount) == 0 && 
			Objects.equals(unitOfMeasure, other.unitOfMeasure);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount.stripTrailingZeros(), unitOfMeasure);
	}

	@Override
	public String toString() {
		return "StockEmbeddable: ['amount="+amount+"', 'unitOfMeasure="+unitOfMeasure+"']";
	}
}