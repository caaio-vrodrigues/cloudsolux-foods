package com.cloudsolux.foods.inventory_service.domain.product.command;

import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;

public final class ProductCreationCommand {

  private final String name;
  private final String model;
  private final String brand;

  private ProductCreationCommand(ProductCreationCommandBuilder builder) {
    ProductValidationAux.validateString(builder.name, "name");
    ProductValidationAux.validateString(builder.model, "model");
    ProductValidationAux.validateString(builder.brand, "brand");
    name = builder.name;
    model = builder.model;
    brand = builder.brand;
  }

  public static class ProductCreationCommandBuilder {
    private String name;
    private String model;
    private String brand;

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

    public ProductCreationCommand build() {
      return new ProductCreationCommand(this);
    }
  }

  public static ProductCreationCommandBuilder builder() {
    return new ProductCreationCommandBuilder();
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
}