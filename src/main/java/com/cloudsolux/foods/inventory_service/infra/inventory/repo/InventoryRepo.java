package com.cloudsolux.foods.inventory_service.infra.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsolux.foods.inventory_service.infra.inventory.entity.InventoryEntity;

public interface InventoryRepo extends JpaRepository<InventoryEntity, Long> {
  
}