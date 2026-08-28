package com.cloudsolux.foods.inventory_service.infra.product.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
  
  boolean existsByNameAndModelAndBrand(String name, String model, String brand);

  @Query(
    value="""
      SELECT new com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse(
        p.id, p.name, p.model, p.brand,
        i.stock.amount, i.stock.unitOfMeasure
      )
      FROM ProductEntity p
      JOIN InventoryEntity i ON i.catalogId = p.id
    """,
    countQuery="""
      SELECT count(p)
      FROM ProductEntity p
      JOIN InventoryEntity i ON i.catalogId = p.id
    """
  )
  Page<ProductResponse> findAllWithStock(Pageable pageable);
}