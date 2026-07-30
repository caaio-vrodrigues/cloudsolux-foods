package com.cloudsolux.foods.inventory_service.domain.product;

import com.cloudsolux.foods.inventory_service.domain.catalog.Catalog;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;

public final class Product extends Catalog {
	
	private final String name;
	private final String model;
	private final String brand;

	private Product(ProductBuilder builder) {
		super(builder.id);
		ProductValidationAux.validateString(builder.name, "name");
		ProductValidationAux.validateString(builder.model, "model");
		ProductValidationAux.validateString(builder.brand, "brand");
		name = builder.name;
		model = builder.model;
		brand = builder.brand;
	}
	
	public static class ProductBuilder {
		private Long id;
		private String name;
		private String model;
		private String brand;
		
		public ProductBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public ProductBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public ProductBuilder model(String model) {
			this.model = model;
			return this;
		}
		
		public ProductBuilder brand(String brand) {
			this.brand = brand;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
	
	public static ProductBuilder builder() {
		return new ProductBuilder();
	}
	
	public String getName() {
		return name;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return "Product: ['id="+getId()+"', 'name="+name+"', 'model="+model+"', 'brand="+brand+"']";
	}
}