package com.cloudsolux.foods.inventory_service.domain.product;

import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.catalog.Catalog;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;

public class Product extends Catalog {
	
	private final String name;
	private final String model;
	private final String brand;

	private Product(ProductBuilder builder) {
		super(builder.id);
		this.name = builder.name;
		this.model = builder.model;
		this.brand = builder.brand;
	}
	
	public static class ProductBuilder {
		private Long id;
		private String name;
		private String model;
		private String brand;
		
		public ProductBuilder id(Long id) {
			// validação na superclasse
			this.id = id;
			return this;
		}
		
		public ProductBuilder name(String name) {
			if(!(name instanceof String)) {
				String receivedClassName = name != null ? 
					name.getClass().getSimpleName() : "null";
				throw new ProductInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("String", receivedClassName));
			}
			if(name.isBlank()) {
				throw new ProductInvalidArgumentException(GlobalMsgCreator
					.emptyFieldValue("Product", "name"));
			}
			this.name = name;
			return this;
		}
		
		public ProductBuilder model(String model) {
      if(!(model instanceof String)) {
				String receivedClassName = model != null ? 
					model.getClass().getSimpleName() : "null";
				throw new ProductInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("String", receivedClassName));
			}
			if(model.isBlank()) {
				throw new ProductInvalidArgumentException(GlobalMsgCreator
					.emptyFieldValue("Product", "model"));
			}
			this.model = model;
			return this;
		}
		
		public ProductBuilder brand(String brand) {
      if(!(brand instanceof String)) {
				String receivedClassName = brand != null ? 
					brand.getClass().getSimpleName() : "null";
				throw new ProductInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("String", receivedClassName));
			}
			if(brand.isBlank()) {
				throw new ProductInvalidArgumentException(GlobalMsgCreator
					.emptyFieldValue("Product", "brand"));
			}
			this.brand = brand;
			return this;
		}
		
		public Product build() {
			if(id == null)
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("Product", "id"));
			if(name == null)
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("Product", "name"));
			if(model == null)
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("Product", "model"));
			if(brand == null)
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("Product", "brand"));
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
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Product other)) return false;
		return name.equals(other.getName()) && 
			model.equals(other.getModel()) && 
			brand.equals(other.getBrand());
	}
	
	public int hashCode() {
		return Objects.hash(name, model, brand);
	}

	public String toString() {
		return "Product ['id="+getId()+"', 'name="+name+"', 'model="+model+"', 'brand="+brand+"']";
	}
}