package com.cloudsolux.foods.inventory_service.domain.inventory.command;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.model.unit_measure.UnitOfMeasure;
import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;

public class InventoryCreationCommand {
  
  private final Long id;
  private final BigDecimal amount;
	private final UnitOfMeasure unitOfMeasure;

  private InventoryCreationCommand(InventoryCreationCommandBuilder builder) {
    id = builder.id;
    amount = builder.amount;
    unitOfMeasure = builder.unitOfMeasure;
  }

  public static class InventoryCreationCommandBuilder {
    private Long id;
    private BigDecimal amount;
	  private UnitOfMeasure unitOfMeasure;

    public InventoryCreationCommandBuilder id(Long id) {
      if(id == null) {
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("InventoryCreationCommand", "id"));
      }
      if(id < 1) {
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .positiveMsg("InventoryCreationCommand", "id", BigDecimal.valueOf(id)));
      }
      this.id = id;
      return this;
    }

    public InventoryCreationCommandBuilder amount(BigDecimal amount) {
      if(amount == null) {
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("InventoryCreationCommand", "amount"));
      }
      if(amount.compareTo(BigDecimal.ZERO) < 0) {
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .positiveOrZeroMsg("InventoryCreationCommand", "amount", amount));
      }
      this.amount = amount;
      return this;
    }

    public InventoryCreationCommandBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
      if(unitOfMeasure == null) {
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("InventoryCreationCommand", "unitOfMeasure"));
      }
      this.unitOfMeasure = unitOfMeasure;
      return this;
    }

    public InventoryCreationCommand build() {
      if(id == null) 
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("InventoryCreationCommand", "id"));
      if(amount == null)
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("InventoryCreationCommand", "amount"));
      if(unitOfMeasure == null)
        throw new InventoryInvalidArgumentException(GlobalMsgCreator
          .nullFieldValueMsg("InventoryCreationCommand", "unitOfMeasure"));
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