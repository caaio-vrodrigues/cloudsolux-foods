package com.cloudsolux.foods.inventory_service.domain.inventory.command;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.util.InventoryValidationAux;

public final class InventoryCreationCommand {
  
  private final Long id;
  private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;

  private InventoryCreationCommand(InventoryCreationCommandBuilder builder) {
    InventoryValidationAux.validatePositiveLong(builder.id, "id");
    InventoryValidationAux.validatePositiveBigDecimal(builder.amount, "amount");
    InventoryValidationAux.validateArgument(builder.unitOfMeasure, "unitOfMeasure");
    id = builder.id;
    amount = builder.amount;
    unitOfMeasure = builder.unitOfMeasure;
  }

  public static class InventoryCreationCommandBuilder {
    private Long id;
    private BigDecimal amount;
	  private UnitOfMeasure unitOfMeasure;

    public InventoryCreationCommandBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public InventoryCreationCommandBuilder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public InventoryCreationCommandBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
      this.unitOfMeasure = unitOfMeasure;
      return this;
    }

    public InventoryCreationCommand build() {
      return new InventoryCreationCommand(this);
    }
  }

  public static InventoryCreationCommandBuilder builder() {
    return new InventoryCreationCommandBuilder();
  }

  public InventoryFactoryKey getFactoryKey() {
    return InventoryFactoryKey.INVENTORY_CREATION;
  }

  public InventoryPersistenceKey getPersistenceKey() {
    return InventoryPersistenceKey.INVENTORY_PERSISTENCE;
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }
}