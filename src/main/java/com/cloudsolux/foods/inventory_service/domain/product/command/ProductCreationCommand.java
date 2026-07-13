package com.cloudsolux.foods.inventory_service.domain.product.command;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.model.unit_measure.UnitOfMeasure;
import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.dto.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;

public class ProductCreationCommand {

  private final String name;
  private final String model;
  private final String brand;
	private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;

  private ProductCreationCommand(ProductCreationCommandBuilder builder) {
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
      if(name == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "name"));
      }
      if(name.isBlank()) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("ProductCreationCommand", "name"));
      }
      this.name = name;
      return this;
    }

    public ProductCreationCommandBuilder model(String model) {
      if(model == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "model"));
      }
      if(model.isBlank()) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("ProductCreationCommand", "model"));
      }
      this.model = model;
      return this;
    }

    public ProductCreationCommandBuilder brand(String brand) {
      if(brand == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "brand"));
      }
      if(brand.isBlank()) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("ProductCreationCommand", "brand"));
      }
      this.brand = brand;
      return this;
    }

    public ProductCreationCommandBuilder amount(BigDecimal amount) {
      if(amount == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "amount"));
      }
      if(amount.compareTo(BigDecimal.ZERO) < 0) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .positiveOrZeroMsg("ProductCreationCommand", "amount", amount));
      }
      this.amount = amount;
      return this;
    }

    public ProductCreationCommandBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
      if(unitOfMeasure == null) {
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "unitOfMeasure"));
      }
      this.unitOfMeasure = unitOfMeasure;
      return this;
    }

    public ProductCreationCommand build() {
      if(name == null) 
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "name"));
      if(model == null) 
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "model"));
      if(brand == null) 
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "brand"));
      if(amount == null)
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "amount"));
      if(unitOfMeasure == null)
        throw new ProductInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("ProductCreationCommand", "unitOfMeasure"));
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

  public BigDecimal getAmount() {
    return amount;
  }

  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }
}