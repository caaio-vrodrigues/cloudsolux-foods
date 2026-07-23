package com.cloudsolux.foods.inventory_service.domain.product.command;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;

public final class ProductCreationCommand {

  private final String name;
  private final String model;
  private final String brand;
	private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;

  private ProductCreationCommand(ProductCreationCommandBuilder builder) {
    InventoryValidationAux.validateArgument(builder.name, "brand");
    InventoryValidationAux.validateArgument(builder.model, "brand");
    InventoryValidationAux.validateArgument(builder.brand, "brand");
    InventoryValidationAux.validateArgument(builder.amount, "brand");
    InventoryValidationAux.validateArgument(builder.unitOfMeasure, "brand");
    name = builder.name;
    model = builder.model;
    brand = builder.brand;
    amount = builder.amount;
    unitOfMeasure = builder.unitOfMeasure;
  }

  public static class ProductCreationCommandBuilder {
    private String name;
    private String model;
    private String brand;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;

    public ProductCreationCommandBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ProductCreationCommandBuilder model(String model) {
      this.model = model;
      return this;
    }

    public ProductCreationCommandBuilder brand(String brand) {
      this.brand = brand;
      return this;
    }

    public ProductCreationCommandBuilder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public ProductCreationCommandBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
      this.unitOfMeasure = unitOfMeasure;
      return this;
    }

    public ProductCreationCommand build() {
      return new ProductCreationCommand(this);
    }
  }

  public static ProductCreationCommandBuilder builder() {
    return new ProductCreationCommandBuilder();
  }

  public ProductFactoryKey getProductCreationKey() {
    return ProductFactoryKey.PRODUCT_CREATION;
  }

  public ProductValidationKey getRequestValidationKey() {
    return ProductValidationKey.VALIDATE_CREATION_REQUEST;
  }

  public ProductPersistenceKey getProductSavingKey() {
    return ProductPersistenceKey.PRODUCT_PERSISTENCE;
  }

  public IdControlKey getIdControlKey() {
    return IdControlKey.CATALOG_ID;
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

  public BigDecimal getAmount() {
    return amount;
  }

  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }
}