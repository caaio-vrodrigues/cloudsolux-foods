package com.cloudsolux.foods.inventory_service.infra.product.adapter.persistence;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;

@Component
public class ProductPersistenceAdapter implements ProductPersistence {

  @Override
  public ProductPersistenceKey getKey() {
    return ProductPersistenceKey.PRODUCT_PERSISTENCE;
  }

  @Override
  public void save(Product product) {
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }
}