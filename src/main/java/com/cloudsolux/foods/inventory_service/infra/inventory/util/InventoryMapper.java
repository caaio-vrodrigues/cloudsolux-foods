package com.cloudsolux.foods.inventory_service.infra.inventory.util;

import com.cloudsolux.foods.inventory_service.domain.inventory.Inventory;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.util.InventoryMapperPort;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.InventoryEntity;

public interface InventoryMapper extends InventoryMapperPort {
  
  InventoryEntity toEntity(Inventory domain);
  Inventory toDomain(InventoryEntity entity);
}