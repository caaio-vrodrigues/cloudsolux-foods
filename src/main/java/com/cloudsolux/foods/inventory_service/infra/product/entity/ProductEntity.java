package com.cloudsolux.foods.inventory_service.infra.product.entity;

import java.util.Objects;

import com.cloudsolux.foods.inventory_service.infra.catalog.CatalogEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity
@Table(name="product", uniqueConstraints = {
	@UniqueConstraint(columnNames = {
		"name", "model", "brand"
	},
	name="UK_product")
})
@SuperBuilder
@Getter
public final class ProductEntity extends CatalogEntity {
  
	@Column(name="name", nullable=false, updatable=false)
	private String name;
	
	@Column(name="model", nullable=false, updatable=false)
	private String model;
	
	@Column(name="brand", nullable=false, updatable=false)
	private String brand;

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof ProductEntity other)) return false;
		return Objects.equals(name, other.name) && 
			Objects.equals(model, other.model) && 
			Objects.equals(brand, other.brand);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, model, brand);
	}

	@Override
	public String toString() {
		return "ProductEntity: ['id="+getId()+"', 'name="+name+"', 'model="+model+"', 'brand="+brand+"']";
	}
}