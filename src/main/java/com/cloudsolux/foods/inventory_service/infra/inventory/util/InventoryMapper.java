package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.Stock;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.InventoryEntity;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.StockEmbeddable;

@Component
public class InventoryMapper {

  public InventoryEntity toEntity(Inventory domain) {
    if(domain == null) {
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("InventoryEntity", "Inventory"));
    }
    StockEmbeddable stock = StockEmbeddable.builder()
      .amount(domain.getStock().getAmount())
      .unitOfMeasure(domain.getStock().getUnitOfMeasure())
      .build();
    return InventoryEntity.builder()
      .catalogId(domain.getCatalogId())
      .stock(stock)
      .build();
  }

  public Inventory toDomain(InventoryEntity entity) {
    if(entity == null) {
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("InventoryEntity", "InventoryEntity"));
    }
    Stock stock = Stock.builder()
      .amount(entity.getStock().getAmount())
      .unitOfMeasure(entity.getStock().getUnitOfMeasure())
      .build();
    return Inventory.builder()
      .catalogId(entity.getCatalogId())
      .stock(stock)
      .build();
  }
}