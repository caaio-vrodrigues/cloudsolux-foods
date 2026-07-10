package com.cloudsolux.foods.inventory_service.domain.product.model.saving;

import com.cloudsolux.foods.inventory_service.domain.product.Product;

public interface ProductSaving extends ProductSavingPort {
 
  void save(Product product);
}