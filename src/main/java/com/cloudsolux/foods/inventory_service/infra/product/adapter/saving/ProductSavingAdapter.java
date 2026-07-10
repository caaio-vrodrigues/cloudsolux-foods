package com.cloudsolux.foods.inventory_service.infra.product.adapter.saving;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSaving;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingKey;

@Component
public class ProductSavingAdapter implements ProductSaving {

  @Override
  public ProductSavingKey getKey() {
    return ProductSavingKey.SAVE_PRODUCT;
  }

  @Override
  public void save(Product product) {
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }
}