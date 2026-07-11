package com.cloudsolux.foods.inventory_service.domain.product.model.persistence;

import com.cloudsolux.foods.inventory_service.domain.product.Product;

public interface ProductPersistence extends ProductPersistencePort {
 
  void save(Product product);
}