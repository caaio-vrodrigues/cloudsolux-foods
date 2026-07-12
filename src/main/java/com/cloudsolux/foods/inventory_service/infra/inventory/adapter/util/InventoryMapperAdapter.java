package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.Stock;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.util.InventoryMapperKey;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.InventoryEntity;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.StockEmbeddable;
import com.cloudsolux.foods.inventory_service.infra.inventory.util.InventoryMapper;

@Component
public class InventoryMapperAdapter implements InventoryMapper {

  @Override
  public InventoryMapperKey getKey() {
    return InventoryMapperKey.INVENTORY_MAPPING;
  }

  @Override
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

  @Override
  public Inventory toDomain(InventoryEntity entity) {
    if(entity == null) {
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Inventory", "InventoryEntity"));
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