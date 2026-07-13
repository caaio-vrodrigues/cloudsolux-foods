package com.cloudsolux.foods.inventory_service.domain.product.model.util;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;

public interface ProductMapper extends ProductMapperPort {
 
  Product toDomain(ProductEntity entity);
  ProductEntity toEntity(Product domain);
}