package com.cloudsolux.foods.inventory_service.infra.product.entity;

import com.cloudsolux.foods.inventory_service.infra.catalog.CatalogEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
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
@EqualsAndHashCode(callSuper=false, onlyExplicitlyIncluded=true)
@SuperBuilder
@Getter
public final class ProductEntity extends CatalogEntity {
  
  @Include 
	@Column(name="name", nullable=false, updatable=false)
	private String name;
	
	@Include
	@Column(name="model", nullable=false, updatable=false)
	private String model;
	
	@Include 
	@Column(name="brand", nullable=false, updatable=false)
	private String brand;

	@Override
	public String toString() {
		return "ProductEntity: ['id="+getId()+"', 'name="+name+"', 'model="+model+"', 'brand="+brand+"']";
	}
}