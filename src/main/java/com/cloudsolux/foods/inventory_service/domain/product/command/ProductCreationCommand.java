package com.cloudsolux.foods.inventory_service.domain.product.command;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.model.UnitOfMeasure;
import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.dto.InventoryCreationCommand;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;

public class ProductCreationCommand {

  private final String name;
  private final String model;
  private final String brand;
	private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;

  private ProductCreationCommand(ProductCreateCommandBuilder builder) {
    name = builder.name;
    model = builder.model;
    brand = builder.brand;
    amount = builder.amount;
    unitOfMeasure = builder.unitOfMeasure;
  }

  public static class ProductCreateCommandBuilder {
    private String name;
    private String model;
    private String brand;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;

    public ProductCreateCommandBuilder name(String name) {
      if(name == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreateCommand", "name"));
      }
      if(name.isBlank()) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("ProductCreateCommand", "name"));
      }
      this.name = name;
      return this;
    }

    public ProductCreateCommandBuilder model(String model) {
      if(model == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreateCommand", "model"));
      }
      if(model.isBlank()) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("ProductCreateCommand", "model"));
      }
      this.model = model;
      return this;
    }

    public ProductCreateCommandBuilder brand(String brand) {
      if(brand == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreateCommand", "brand"));
      }
      if(brand.isBlank()) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("ProductCreateCommand", "brand"));
      }
      this.brand = brand;
      return this;
    }

    public ProductCreateCommandBuilder amount(BigDecimal amount) {
      if(amount == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreateCommand", "amount"));
      }
      if(amount.compareTo(BigDecimal.ZERO) < 0) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .positiveOrZeroMsg("ProductCreateCommand", "amount", amount));
      }
      this.amount = amount;
      return this;
    }

    public ProductCreateCommandBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
      if(unitOfMeasure == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreateCommand", "unitOfMeasure"));
      }
      this.unitOfMeasure = unitOfMeasure;
      return this;
    }

    public ProductCreationCommand build() {
      return new ProductCreationCommand(this);
    }
  }

  public static ProductCreateCommandBuilder builder() {
    return new ProductCreateCommandBuilder();
  }

  public InventoryCreationCommand toInventoryCreationCommand(Long id) {
    return InventoryCreationCommand.builder()
      .id(id)
      .amount(amount)
      .unitOfMeasure(unitOfMeasure)
      .build();
  }

  public ProductCreationKey getProductCreationKey() {
    return ProductCreationKey.PRODUCT_CREATION;
  }

  public ProductValidationKey getRequestValidationKey() {
    return ProductValidationKey.VALIDATE_CREATION_REQUEST;
  }

  public ProductSavingKey getProductSavingKey() {
    return ProductSavingKey.SAVE_PRODUCT;
  }

  public ProductDTOFactoryKey getResponseCreationKey() {
    return ProductDTOFactoryKey.CREATE_RESPONSE;
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