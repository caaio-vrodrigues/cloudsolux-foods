package com.cloudsolux.foods.inventory_service.infra.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
  
  boolean existsByNameAndModelAndBrand(String name, String model, String brand);
}